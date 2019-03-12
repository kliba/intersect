package test_intersectings;

import intersectings.IntersectedRectangles;
import org.junit.Test;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class TestIntersectedRectangles {

    @Test
    public void testFindIntersectsBy1Intersect() {
        List<Rectangle> testList = new ArrayList<>();
        testList.add(new Rectangle(0, 0, 2, 2));
        testList.add(new Rectangle(1, 1, 2, 2));

        List<Rectangle> intersectList = new ArrayList<>();
        intersectList.add(new Rectangle(1, 1, 1, 1));

        assertEquals(intersectList, IntersectedRectangles.findIntersects(testList));
    }

    @Test
    public void testFindIntersectsByMoreIntersect() {
        List<Rectangle> testList = new ArrayList<>();
        testList.add(new Rectangle(0, 0, 2, 2));
        testList.add(new Rectangle(1, 1, 2, 2));
        testList.add(new Rectangle(2, 2, 2, 2));

        List<Rectangle> intersectList = new ArrayList<>();
        intersectList.add(new Rectangle(1, 1, 1, 1));
        //it is valid rectangle on the Rectangle.Intersection()
        intersectList.add(new Rectangle(2, 2, 0, 0));
        intersectList.add(new Rectangle(2, 2, 1, 1));

        assertEquals(intersectList, IntersectedRectangles.findIntersects(testList));
    }

    @Test
    public void testFindIntersectsByNoPositiveIntersect() {
        List<Rectangle> testList = new ArrayList<>();
        testList.add(new Rectangle(0, 0, 2, 2));
        testList.add(new Rectangle(5, 5, 5, 5));

        List<Rectangle> intersectList = new ArrayList<>();
        intersectList.add(new Rectangle(5, 5, -3, -3));

        assertEquals(intersectList, IntersectedRectangles.findIntersects(testList));
    }

    @Test
    public void testFindIntersectsByEmptyList() {
        List<Rectangle> testList = new ArrayList<>();
        List<Rectangle> intersectList = new ArrayList<>();

        assertEquals(intersectList, IntersectedRectangles.findIntersects(testList));
    }

    @Test
    public void testRemoveDuplicatesAndNotValidIntersectsByNothingToRemove() {
        List<Rectangle> testList = new ArrayList<>();
        testList.add(new Rectangle(0, 0, 2, 2));
        testList.add(new Rectangle(5, 5, 5, 5));

        List<Rectangle> resultList = new ArrayList<>();
        resultList.add(new Rectangle(0, 0, 2, 2));
        resultList.add(new Rectangle(5, 5, 5, 5));

        assertEquals(resultList, IntersectedRectangles.removeDuplicatesAndNotValidIntersects(testList));
    }

    @Test
    public void testRemoveDuplicatesAndNotValidIntersectsByRemoveADuplicated() {
        List<Rectangle> testList = new ArrayList<>();
        testList.add(new Rectangle(0, 0, 2, 2));
        testList.add(new Rectangle(5, 5, 5, 5));
        testList.add(new Rectangle(5, 5, 5, 5));

        List<Rectangle> resultList = new ArrayList<>();
        resultList.add(new Rectangle(0, 0, 2, 2));
        resultList.add(new Rectangle(5, 5, 5, 5));

        assertEquals(resultList, IntersectedRectangles.removeDuplicatesAndNotValidIntersects(testList));
    }

    @Test
    public void testRemoveDuplicatesAndNotValidIntersectsByRemoveWidthIsMinusOfRect() {
        List<Rectangle> testList = new ArrayList<>();
        testList.add(new Rectangle(0, 0, 2, 2));
        testList.add(new Rectangle(5, 5, 5, 5));
        testList.add(new Rectangle(5, 5, -5, 5));

        List<Rectangle> resultList = new ArrayList<>();
        resultList.add(new Rectangle(0, 0, 2, 2));
        resultList.add(new Rectangle(5, 5, 5, 5));

        assertEquals(resultList, IntersectedRectangles.removeDuplicatesAndNotValidIntersects(testList));
    }

    @Test
    public void testRemoveDuplicatesAndNotValidIntersectsByRemoveHeightIsMinusOfRect() {
        List<Rectangle> testList = new ArrayList<>();
        testList.add(new Rectangle(0, 0, 2, 2));
        testList.add(new Rectangle(5, 5, 5, 5));
        testList.add(new Rectangle(5, 5, 12, -5));

        List<Rectangle> resultList = new ArrayList<>();
        resultList.add(new Rectangle(0, 0, 2, 2));
        resultList.add(new Rectangle(5, 5, 5, 5));

        assertEquals(resultList, IntersectedRectangles.removeDuplicatesAndNotValidIntersects(testList));
    }

    @Test
    public void testRemoveDuplicatesAndNotValidIntersectsByEmptyList() {
        List<Rectangle> testList = new ArrayList<>();

        List<Rectangle> resultList = new ArrayList<>();

        assertEquals(resultList, IntersectedRectangles.removeDuplicatesAndNotValidIntersects(testList));
    }
}
