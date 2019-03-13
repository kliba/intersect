import intersectings.IntersectedRectangles;
import reader_of_JSON.JSONToRectangles;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        boolean again = true;

        while (again) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("");
            System.out.println("-------------------------------------------------------------------------------------");
            System.out.println("Enter your FULL PATH to discover the rectangles intersections (or press `q` to quit):");
            String fullPath = scanner.nextLine();

            //Requested rectangle and all intersection lists
            List<Rectangle> listOfAllRectangles = new ArrayList<>(JSONToRectangles.readRectsJSON(fullPath));
            List<Rectangle> listOfAllIntersects = new ArrayList<>(IntersectedRectangles.findAllIntersects(listOfAllRectangles));


            if (fullPath.equals("q") || fullPath.equals("Q")) {
                again = false;
                System.out.println("Bye bye!");
            } else {
                IntersectedRectangles.findAndPrintOutput(JSONToRectangles.readRectsJSON(fullPath));
            }
        }
    }

}
