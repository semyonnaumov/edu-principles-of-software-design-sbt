package ru.psd.junit;

import org.junit.*;
import java.util.*;

import static org.junit.Assert.*;

public class SquareTest {
    private static final Map<Object, Double> calculateAreaData = new HashMap<Object, Double>();

    @Before
    public void setUp() {
        calculateAreaData.put(new Square(10), 100d);
        calculateAreaData.put(new Square(0.3d), 0.09d);
        calculateAreaData.put(new Square(0), 0d);
    }

    @Test
    public void calculateArea() {
        for (Map.Entry<Object, Double> entry : calculateAreaData.entrySet()) {
            final Shape testShape = (Shape)entry.getKey();
            final Double expected = entry.getValue();
            final Double actual = testShape.calculateArea();
            assertEquals(expected, actual);
        }
    }
}