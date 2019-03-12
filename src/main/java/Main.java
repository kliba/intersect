import intersectings.IntersectedRectangles;
import reader_of_JSON.JSONToRectangles;

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

            if (fullPath.equals("q") || fullPath.equals("Q")) {
                again = false;
                System.out.println("Bye bye!");
            } else {
                IntersectedRectangles.printOutput(JSONToRectangles.readRectsJSON(fullPath));
            }
        }
    }

}
