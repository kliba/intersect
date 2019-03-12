package reader_of_JSON;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.awt.*;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public final class JSONToRectangles {

    private static int resultRectangleListMaxSize = 10;
    private static Rectangle rectangle;


    /**
     * Based on the param it finds the json file that should be read. In the file it only handle the JSON array
     * that mapped by "rects" keyword. Then gets required data line by line. These data are checked by
     * isRectangleAndCoordinateValid(), then the output rectangle list size is checked by isListSizeNr().
     * If the size is exactly ^resultListMaxSize^ field it stops reading from the file it just returns the required list.
     * As it uses JSONParser, FileReader, JSONArray, isRectangleAndCoordinateValid() etc...
     * We can expect to following exceptions: FIlE NOT FOUND, ILLEGAL ARGUMENT, IO, NUMBER FORMAT, EXCEPTION
     *
     * @param fullPath This shows the direction to out JSON file.
     * @return The return value is a rectangle list. A list what contains all valid rectangles up to defined size.
     */
    public static List<Rectangle> readRectsJSON(String fullPath) {
        List<Rectangle> lilstOfRectangles = new ArrayList<>();
        JSONParser parser = new JSONParser();

        try {
            Object object = parser.parse(new FileReader(fullPath));
            JSONObject jsonObject = (JSONObject) object;
            JSONArray rectanglesJSON = (JSONArray) jsonObject.get("rects");

            for (Object rect : rectanglesJSON) {
                if (rect instanceof JSONObject) {
                    JSONObject rectJson = (JSONObject) rect;

                    try {
                        Long x = (Long) rectJson.get("x");
                        Long y = (Long) rectJson.get("y");
                        Long h = (Long) rectJson.get("h");
                        Long w = (Long) rectJson.get("w");

                        if (isRectangleAndCoordinateValid(x, y, h, w)) {
                            //Rectangle(int x, int y, int width, int height) - constructor (Class Rectangle)
                            rectangle = new Rectangle(x.intValue(), y.intValue(), w.intValue(), h.intValue());
                            lilstOfRectangles.add(rectangle);
                        }

                        if (isListSizeNr(lilstOfRectangles, resultRectangleListMaxSize)) {
                            break;
                        }

                    } catch (IllegalArgumentException e) {
                        e.printStackTrace();
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return lilstOfRectangles;

    }

    /**
     * Checks if the x coordinate, y coordinate, height, and width are valid so fit to rectangle constructor. Then
     * checks that if the rectangle can be placing to an Integer coordinate table. The height and/or width can be only
     * positive integer. (height > 0, width > 0)
     * x coordinate added to width less than integer max value (x + w > 2,147,483,647 (inclusive)),
     * y coordinate added to height less than integer max value (y + h > 2,147,483,647 (inclusive)),
     * x coordinate must be greater than integer min value (x > -2,147,483,647 (inclusive)),
     * y coordinate must be greater than integer min value (y > -2,147,483,647 (inclusive)),
     *
     * @param x as rectangle x coordinate
     * @param y as rectangle y coordinate
     * @param h as height of the rectangle
     * @param w as width of the rectangle
     * @return true if the parameters can create a rectangle and this rectangle can be placed to an
     * integer coordinate table. On the other hand we can except to an Illegal Argument Exception.
     */
    public static boolean isRectangleAndCoordinateValid(Long x, Long y, Long h, Long w) {

        if (x < Integer.MIN_VALUE || y < Integer.MIN_VALUE || h < 1 || w < 1 ||
                x + w > Integer.MAX_VALUE || y + h > Integer.MAX_VALUE) {

            throw new IllegalArgumentException("Rectangle is not fit to a 2D integer coordinate table or width " +
                    "and/or height is not positive number.");
        }

        return true;
    }

    /**
     * Checks the input list size. If this list size is equal to nr param returns true.
     *
     * @param listOfRectangles Rectangles list, what size should be checked.
     * @param nr               Size of the list we expect.
     * @return true if the input list size param is equal to the input nr param.
     */
    public static boolean isListSizeNr(List<Rectangle> listOfRectangles, int nr) {
        return listOfRectangles.size() == nr;
    }


}
