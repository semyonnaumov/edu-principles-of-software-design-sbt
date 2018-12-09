package ru.psd.junit;

import org.junit.Test;

import static org.junit.Assert.*;

public class ShapeUtilsTest {

    @Test
    public void testMax() {
        Shape a = new Circle(10);
        Shape b = new Rectangle(1, 1);
        assertTrue(a == ShapeUtils.max(a, b));
    }
}