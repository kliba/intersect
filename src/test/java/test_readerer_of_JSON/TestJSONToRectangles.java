package test_readerer_of_JSON;

import org.junit.Test;
import reader_of_JSON.JSONToRectangles;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class TestJSONToRectangles {

    // isRectangleAndCoordinateValid(Long x, Long y, Long h, Long w) --> test cases
    @Test
    public void testIsRectangleAndCoordinateValidByPositiveValidValues() {
        Long x = 20l;
        Long y = 202l;
        Long h = 203l;
        Long w = 240l;

        assertTrue(JSONToRectangles.isRectangleAndCoordinateValid(x, y, h, w));
    }

    @Test
    public void testIsRectangleAndCoordinateValidByNegativeValidValues() {
        Long x = -20l;
        Long y = -202l;
        Long h = 203l;
        Long w = 240l;

        assertTrue(JSONToRectangles.isRectangleAndCoordinateValid(x, y, h, w));
    }

    @Test
    public void testIsRectangleAndCoordinateValidByZeroCoordinatePositiveValidValues() {
        Long x = 0l;
        Long y = 0l;
        Long h = 203l;
        Long w = 240l;

        assertTrue(JSONToRectangles.isRectangleAndCoordinateValid(x, y, h, w));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testIsRectangleAndCoordinateValidByNegativeHeight() {
        Long x = 1l;
        Long y = 12l;
        Long h = -203l;
        Long w = 240l;

        JSONToRectangles.isRectangleAndCoordinateValid(x, y, h, w);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testIsRectangleAndCoordinateValidByNegativeWeight() {
        Long x = 1l;
        Long y = 12l;
        Long h = 203l;
        Long w = -2240l;

        JSONToRectangles.isRectangleAndCoordinateValid(x, y, h, w);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testIsRectangleAndCoordinateValidByZeroHeight() {
        Long x = 1l;
        Long y = 12l;
        Long h = 0l;
        Long w = -2240l;

        JSONToRectangles.isRectangleAndCoordinateValid(x, y, h, w);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testIsRectangleAndCoordinateValidByZeroWeight() {
        Long x = 1l;
        Long y = 12l;
        Long h = 10l;
        Long w = 0l;

        JSONToRectangles.isRectangleAndCoordinateValid(x, y, h, w);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testIsRectangleAndCoordinateValidByXLessThanIntMin() {
        Long x = Integer.MIN_VALUE - 1l;
        Long y = 12l;
        Long h = 203l;
        Long w = 2240l;

        JSONToRectangles.isRectangleAndCoordinateValid(x, y, h, w);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testIsRectangleAndCoordinateValidByYLessThanIntMin() {
        Long x = 1l;
        Long y = Integer.MIN_VALUE - 12l;
        Long h = 203l;
        Long w = 2240l;

        JSONToRectangles.isRectangleAndCoordinateValid(x, y, h, w);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testIsRectangleAndCoordinateValidByXAndWGreaterThanIntMax() {
        Long x = (long) Integer.MAX_VALUE;
        Long y = 12l;
        Long h = 203l;
        Long w = 2240l;

        JSONToRectangles.isRectangleAndCoordinateValid(x, y, h, w);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testIsRectangleAndCoordinateValidByYAndHGreaterThanIntMax() {
        Long x = 122l;
        Long y = (long) Integer.MAX_VALUE;
        Long h = 1l;
        Long w = 2240l;

        JSONToRectangles.isRectangleAndCoordinateValid(x, y, h, w);
    }


    // isListSizeNr(List<Rectangle> listOfRectangles, int nr) --> test cases
    @Test
    public void testIsListSizeNrLessSize() {
        List<Rectangle> testList = new ArrayList<>();
        testList.add(new Rectangle(0, 0, 1, 1));

        assertFalse(JSONToRectangles.isListSizeNr(testList, 2));
    }

    @Test
    public void testIsListSizeNrGreaterSize() {
        List<Rectangle> testList = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            testList.add(new Rectangle(0, 0, 1, 1));
        }

        assertFalse(JSONToRectangles.isListSizeNr(testList, 2));
    }

    @Test
    public void testIsListSizeNrExpectedSize() {
        List<Rectangle> testList = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            testList.add(new Rectangle(0, 0, 1, 1));
        }

        assertTrue(JSONToRectangles.isListSizeNr(testList, 10));
    }


    // readRectsJSON(String fullPath) --> test cases
    @Test
    public void testReadRectsJSONByValidDataLessJSONLines() {
        String path = "./documents/testJSONfiles/JSON_valid_data_test1";
        List<Rectangle> compareTo = new ArrayList<>();
        compareTo.add(new Rectangle(0, 0, 1, 1));
        compareTo.add(new Rectangle(2, 1, 2, 2));
        compareTo.add(new Rectangle(-120, -200, 50, 50));
        compareTo.add(new Rectangle(320, 420, 50, 1));
        compareTo.add(new Rectangle(12345, 23456, 789, 890));
        compareTo.add(new Rectangle(12, 12, 2, 4));

        assertEquals(compareTo.size(), JSONToRectangles.readRectsJSON(path).size());
        assertEquals(compareTo.get(0), JSONToRectangles.readRectsJSON(path).get(0));
        assertEquals(compareTo.get(1), JSONToRectangles.readRectsJSON(path).get(1));
        assertEquals(compareTo.get(2), JSONToRectangles.readRectsJSON(path).get(2));
        assertEquals(compareTo.get(3), JSONToRectangles.readRectsJSON(path).get(3));
        assertEquals(compareTo.get(4), JSONToRectangles.readRectsJSON(path).get(4));
        assertEquals(compareTo.get(5), JSONToRectangles.readRectsJSON(path).get(5));
    }

    @Test
    public void testReadRectsJSONByValidDataAndGreaterJSONLines() {
        String path = "./documents/testJSONfiles/JSON_valid_data_greater_test2";
        List<Rectangle> compareTo = new ArrayList<>();
        compareTo.add(new Rectangle(0, 0, 1, 1));
        compareTo.add(new Rectangle(2, 1, 2, 2));
        compareTo.add(new Rectangle(-120, -200, 50, 50));
        compareTo.add(new Rectangle(320, 420, 50, 1));
        compareTo.add(new Rectangle(12345, 23456, 789, 890));
        compareTo.add(new Rectangle(12, 12, 2, 4));
        compareTo.add(new Rectangle(12345, 23456, 789, 890));
        compareTo.add(new Rectangle(2345, 3456, 89, 90));
        compareTo.add(new Rectangle(345, 456, 9, 110));
        compareTo.add(new Rectangle(34, 43, 12, 21));

        assertEquals(compareTo.size(), JSONToRectangles.readRectsJSON(path).size());
        for (int i = 0; i < compareTo.size(); i++) {
            assertEquals(compareTo.get(i), JSONToRectangles.readRectsJSON(path).get(i));
        }
    }

    @Test
    public void testReadRectsJSONByInvalidCoordinateData() {
        String path = "./documents/testJSONfiles/JSON_invalid_coordinate_data_test3";
        List<Rectangle> compareTo = new ArrayList<>();
        compareTo.add(new Rectangle(2, 1, 2, 2));
        compareTo.add(new Rectangle(-120, -200, 50, 50));
        compareTo.add(new Rectangle(320, 420, 50, 1));
        compareTo.add(new Rectangle(12345, 23456, 789, 890));
        compareTo.add(new Rectangle(12, 12, 2, 4));

        assertEquals(compareTo.size(), JSONToRectangles.readRectsJSON(path).size());
        for (int i = 0; i < compareTo.size(); i++) {
            assertEquals(compareTo.get(i), JSONToRectangles.readRectsJSON(path).get(i));
        }
    }

    @Test
    public void testReadRectsJSONByInvalidRectangle() {
        String path = "./documents/testJSONfiles/JSON_invalid_rectangle_data_test4";
        List<Rectangle> compareTo = new ArrayList<>();
        compareTo.add(new Rectangle(2, 1, 2, 2));
        compareTo.add(new Rectangle(-120, -200, 50, 50));
        compareTo.add(new Rectangle(320, 420, 50, 1));
        compareTo.add(new Rectangle(12345, 23456, 789, 890));
        compareTo.add(new Rectangle(12, 12, 2, 4));

        assertEquals(compareTo.size(), JSONToRectangles.readRectsJSON(path).size());
        for (int i = 0; i < compareTo.size(); i++) {
            assertEquals(compareTo.get(i), JSONToRectangles.readRectsJSON(path).get(i));
        }
    }
}



