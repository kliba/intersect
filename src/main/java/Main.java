import intersectings.IntersectedRectangles;
import reader_of_JSON.JSONToRectangles;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

    String fullPath = "testJSONfiles/JSON_invalid_rects_tag_test5";

        System.out.println(JSONToRectangles.readRectsJSON(fullPath));


        List<Rectangle> testRectangles = new ArrayList<>();
        testRectangles.add(new Rectangle(100, 100, 250, 80));
        testRectangles.add(new Rectangle(120, 200, 250, 150));
        testRectangles.add(new Rectangle(140, 160, 250, 100));
        testRectangles.add(new Rectangle(160, 140, 350, 190));

        IntersectedRectangles.printOutput(testRectangles);
    }

}
