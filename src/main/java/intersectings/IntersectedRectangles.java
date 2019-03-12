package intersectings;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public final class IntersectedRectangles {


    /**
     * It compares every input element to every input element (the element is not compared by itself) of the
     * listOfRectangle array list.
     * If finds intersect between two elements takes that to a list as a Rectangle object.
     *
     * @param listOfRectangles List what is compared to itself.
     * @return listOfIntersections. Every element of it defines an overlapping area as a rectangle.
     */
    public static List<Rectangle> findIntersects(List<Rectangle> listOfRectangles) {
        List<Rectangle> listOfIntersections = new ArrayList<>();

        for (int i = 0; i < listOfRectangles.size() - 1; i++) {
            for (int j = i + 1; j < listOfRectangles.size(); j++) {
                listOfIntersections.add(listOfRectangles.get(i).intersection(listOfRectangles.get(j)));
            }
        }

        return listOfIntersections;
    }

    /**
     * Iterates on the input parameter and takes these elements into a new list if the height and/or weight is zero of
     * element (Rectangle object) or the current element has already been in the new list it does not add it to the
     * new list.
     *
     * @param listOfMultipleIntersections a list what contains the multiple intersections even if that is not valid object.
     * @return A list that contains every element one time where the height and weight bigger than zero.
     */
    public static List<Rectangle> removeDuplicatesAndNotValidIntersects(List<Rectangle> listOfMultipleIntersections) {
        List<Rectangle> listOfValidIntersects = new ArrayList<>();

        for (Rectangle rect : listOfMultipleIntersections) {
            if (!listOfValidIntersects.contains(rect) &&
                    rect.getWidth() > 0 && rect.getHeight() > 0) {
                listOfValidIntersects.add(rect);
            }
        }

        return listOfValidIntersects;
    }

    /**
     * Prints the input list as the specification defined. If the parameter size is smaller than 1 it prints
     * "The input rectangle list is empty." - message.
     * (e.g:
     * Input:
     * 1: Rectangle at (0,0), w=5, h=5.
     * 2: Rectangle at (0,0), w=5, h=5.
     * 3: Rectangle at (1,1), w=5, h=5.
     * 4: Rectangle at (2,2), w=5, h=5.
     * 5: Rectangle at (0,1), w=2, h=2.)
     *
     * @param listOfRectangles
     */
    private static void printRectangles(List<Rectangle> listOfRectangles) {
        System.out.println("Input:");

        if (0 < listOfRectangles.size()) {
            for (int i = 0; i < listOfRectangles.size(); i++) {
                System.out.println("    " + (i + 1) + ": Rectangle at (" + listOfRectangles.get(i).x + "," +
                        listOfRectangles.get(i).y + "), w=" + listOfRectangles.get(i).width +
                        ", h=" + listOfRectangles.get(i).height + ".");
            }
        } else {
            System.out.println("    The input rectangle list is empty.");
        }
    }

    /**
     * Compares the elements ot the listOfRectangles (one element is not compared by itself). If there is intersection
     * creating a new Rectangle object by the parameters of intersect. If the height and width are bigger than zero
     * that is going to be printed as the specification required.
     * If the intersection list is empty it prints "There is no single intersect." -message.
     * There is an integer line counter. This signs the printed line number. It increases by new printed line.
     * (e.g:
     * 1: Between rectangle 1 and 3 at (140,160), w=210, h=20.
     * 2: Between rectangle 1 and 4 at (160,140), w=190, h=40.
     * 3: Between rectangle 2 and 3 at (140,200), w=230, h=60.
     * 4: Between rectangle 2 and 4 at (160,200), w=210, h=130.
     * 5: Between rectangle 3 and 4 at (160,160), w=230, h=100.)
     *
     * @param listOfRectangles specified rectangle list
     * @param lineCounter      specified number where the increasing starts.
     * @return lineCounter what has already been increased by the printed lines number.
     */
    private static int printIntersections(List<Rectangle> listOfRectangles, int lineCounter) {
        int originLineCounter = lineCounter;

        System.out.println("");
        System.out.println("Intersections:");

        if (listOfRectangles.size() > 0) {
            for (int i = 0; i < listOfRectangles.size() - 1; i++) {
                for (int j = i + 1; j < listOfRectangles.size(); j++) {
                    Rectangle intersect = new Rectangle(listOfRectangles.get(i).intersection(listOfRectangles.get(j)));

                    //Rectangle(int x, int y, int width, int height) - constructor (Class Rectangle)
                    if (intersect.width > 0 && intersect.height > 0) {
                        System.out.println("    " + lineCounter + ": Between rectangle " + (i + 1) +
                                " and " + (j + 1) + " at (" + intersect.x + "," +
                                intersect.y + "), w=" + intersect.width + ", h=" + intersect.height + ".");
                        lineCounter++;
                    }
                }
            }
            if (originLineCounter == lineCounter) {
                System.out.println("There is no single intersect.");
            }
        } else {
            System.out.println("There is no single intersect.");
        }

        return lineCounter;
    }

    /**
     * Creates an intersect list from the rectangle list param. Then it creates a multiple intersects list based on the
     * newly created intersect list. If our multiple list is not empty it iterates on the multiple intersects list
     * and these elements compared to the elements of the rectangle list param. When the current element of multiple
     * list and element of rectangle list are equals it stores their serial number in a string builder.
     * Using the data of this string builder and elements of the rectangle list it prints out the multiple intersects
     * as the specification requires. This method waits a line counter param where the line counting starts.
     * If the listOfRectangle param is empty it writes "There is no multiple intersect." - message.
     * (e.g:
     * 6: Between rectangle 1, 3 and 4 at (160,160), w=190, h=20.
     * 7: Between rectangle 2, 3 and 4 at (160,200), w=210, h=60. )
     *
     * @param listOfRectangles specified rectangle list
     * @param lineCounter      where the increased counting starts from.
     */
    private static void printMultiIntersections(List<Rectangle> listOfRectangles, int lineCounter) {
        List<Rectangle> listOfIntersects = new ArrayList<>(findIntersects(listOfRectangles));
        List<Rectangle> listOfMultiIntersects = new ArrayList<>(findIntersects(listOfIntersects));
        listOfMultiIntersects = removeDuplicatesAndNotValidIntersects(listOfMultiIntersects);

        if (listOfMultiIntersects.size() > 0) {

            for (Rectangle rectangle : listOfMultiIntersects) {

                StringBuilder relevantRects = new StringBuilder();

                for (int i = 0; i < listOfRectangles.size(); i++) {

                    if (listOfRectangles.get(i).contains(rectangle)) {
                        relevantRects.append(i + 1);
                    }
                }

                StringBuilder formedRelevantRects = new StringBuilder();
                for (int i = 0; i < relevantRects.length(); i++) {

                    if (i == relevantRects.length() - 2) {
                        formedRelevantRects.append(relevantRects.charAt(i)).append(" and ");
                    } else if (i == relevantRects.length() - 1) {
                        formedRelevantRects.append(relevantRects.charAt(i));
                    } else {
                        formedRelevantRects.append(relevantRects.charAt(i)).append(", ");
                    }
                }
                System.out.println("    " + lineCounter + ": Between rectangle " + formedRelevantRects +
                        " at (" + rectangle.x + "," + rectangle.y +
                        "), w=" + rectangle.width + ", h=" + rectangle.height +
                        ".");
                lineCounter++;
            }
        } else {
            System.out.println("There is no multiple intersect.");
        }
    }

    /**
     * There is a line counter to be declared and assigned to a number where the increasing counting starts by
     * new printed intersection line. These counted lines will appears on the console as intersecting line signer.
     * Prints the list of rectangles elements by invoking printRectangles().
     * Also prints the list of intersects elements by invoking printIntersections().
     * Also prints the list of intersects elements by invoking printMultiIntersections()
     *
     * @param listOfRectangles specified rectangle list.
     */
    public static void printOutput(List<Rectangle> listOfRectangles) {
        int lineCounter = 1;

        printRectangles(listOfRectangles);
        lineCounter = printIntersections(listOfRectangles, lineCounter);
        printMultiIntersections(listOfRectangles, lineCounter);
    }
}
