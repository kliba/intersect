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
     * Prints the input list as the specification defined. If the parameter size is smaller than 1 it displays
     * a warnint message
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
    public static void printRectangles(List<Rectangle> listOfRectangles) {
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

    public static int printIntersections(List<Rectangle> listOfRectangles, int lineCounter) {
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
        } else {
            System.out.println("There is no intersect.");
        }

        return lineCounter;
    }

    public static void printMultiIntersections(List<Rectangle> listOfRectangles, int lineCounter) {
        List<Rectangle> listOfIntersects = new ArrayList<>(findIntersects(listOfRectangles));
        List<Rectangle> listOfMultiIntersects = new ArrayList<>(findIntersects(listOfIntersects));
        listOfMultiIntersects = removeDuplicatesAndNotValidIntersects(listOfMultiIntersects);

        if (listOfMultiIntersects.size() > 0) {

            for (int i = 0; i < listOfMultiIntersects.size(); i++) {

                String relevantRects = "";
                for (int j = 0; j < listOfRectangles.size(); j++) {
                    if (listOfRectangles.get(j).contains(listOfMultiIntersects.get(i))) {
                        relevantRects += (j + 1);
                    }
                }

                String formedRelevantRects = "";
                for (int k = 0; k < relevantRects.length(); k++) {
                    if (k == relevantRects.length() - 2) {
                        formedRelevantRects += relevantRects.charAt(k) + " and ";
                    } else if (k == relevantRects.length() - 1) {
                        formedRelevantRects += relevantRects.charAt(k) + "";
                    } else {
                        formedRelevantRects += relevantRects.charAt(k) + ", ";
                    }
                }
                System.out.println("    " + lineCounter + ": Between rectangle " + formedRelevantRects +
                        " at (" + listOfMultiIntersects.get(i).x + "," + listOfMultiIntersects.get(i).y +
                        "), w=" + listOfMultiIntersects.get(i).width + ", h=" + listOfMultiIntersects.get(i).height +
                        ".");
                lineCounter++;
            }
        } else {
            System.out.println("There is no intersect.");
        }
    }

    public static void printOutput(List<Rectangle> listOfRectangles) {
        int lineCounter = 1;

        printRectangles(listOfRectangles);
        lineCounter = printIntersections(listOfRectangles, lineCounter);
        printMultiIntersections(listOfRectangles, lineCounter);
    }
}
