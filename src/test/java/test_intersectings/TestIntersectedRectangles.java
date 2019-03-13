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

    @Test
    public void testFindAllIntersectsByIntersects() {
        List<Rectangle> testRectangles = new ArrayList<>();
        testRectangles.add(new Rectangle(100, 100, 250, 80));
        testRectangles.add(new Rectangle(120, 200, 250, 150));
        testRectangles.add(new Rectangle(140, 160, 250, 100));
        testRectangles.add(new Rectangle(160, 140, 350, 190));

        List<Rectangle> resultList = new ArrayList<>();
        resultList.add(new Rectangle(140, 160, 210, 20));
        resultList.add(new Rectangle(160, 140, 190, 40));
        resultList.add(new Rectangle(140, 200, 230, 60));
        resultList.add(new Rectangle(160, 200, 210, 130));
        resultList.add(new Rectangle(160, 160, 230, 100));
        resultList.add(new Rectangle(160, 160, 190, 20));
        resultList.add(new Rectangle(160, 200, 210, 60));

        assertEquals(resultList, IntersectedRectangles.findAllIntersects(testRectangles));
    }

    @Test
    public void testFindAllIntersectsByNoIntersects() {
        List<Rectangle> testRectangles = new ArrayList<>();
        testRectangles.add(new Rectangle(1, 1, 25, 25));
        testRectangles.add(new Rectangle(-10, -20, 2, 3));
        testRectangles.add(new Rectangle(-140, 160, 40, 40));
        testRectangles.add(new Rectangle(160, -140, 35, 90));

        List<Rectangle> resultList = new ArrayList<>();

        assertEquals(resultList, IntersectedRectangles.findAllIntersects(testRectangles));
    }

    @Test
    public void testFindAllIntersectsByOneRectangle() {
        List<Rectangle> testRectangles = new ArrayList<>();
        testRectangles.add(new Rectangle(100, 120, 25, 400));

        List<Rectangle> resultList = new ArrayList<>();

        assertEquals(resultList, IntersectedRectangles.findAllIntersects(testRectangles));
    }

    @Test
    public void testFindAllIntersectsByEmptyList() {
        List<Rectangle> testRectangles = new ArrayList<>();
        List<Rectangle> resultList = new ArrayList<>();

        assertEquals(resultList, IntersectedRectangles.findAllIntersects(testRectangles));
    }

    @Test
    public void testFindAllIntersectsBySameRectangles() {
        List<Rectangle> testRectangles = new ArrayList<>();
        testRectangles.add(new Rectangle(0, 0, 1, 1));
        testRectangles.add(new Rectangle(0, 0, 1, 1));
        testRectangles.add(new Rectangle(10, 10, 1, 1));
        testRectangles.add(new Rectangle(10, 10, 1, 1));

        List<Rectangle> resultList = new ArrayList<>();
        resultList.add(new Rectangle(0, 0, 1, 1));
        resultList.add(new Rectangle(10, 10, 1, 1));

        assertEquals(resultList, IntersectedRectangles.findAllIntersects(testRectangles));
    }
}
