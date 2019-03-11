import reader_of_JSON.JSONToRectangles;

public class Main {

    public static void main(String[] args) {

    String fullPath = "testJSONfiles/JSON_invalid_rects_tag_test5";

        System.out.println(JSONToRectangles.readRectsJSON(fullPath));
    }

}
