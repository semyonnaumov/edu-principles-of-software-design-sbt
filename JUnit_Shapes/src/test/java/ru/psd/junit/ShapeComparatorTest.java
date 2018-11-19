package ru.psd.junit;

import org.junit.Test;

import static org.junit.Assert.*;

public class ShapeComparatorTest {

    @Test
    public void testCompare() {
        Shape square = new Square(10);
        Shape rectangle = new Rectangle(10, 10);
        Shape littleSquare = new Square(1);
        ShapeComparator comparator = new ShapeComparator();
        assertEquals(0, comparator.compare(square, rectangle));
        assertTrue(comparator.compare(square, littleSquare) > 0);
    }
}