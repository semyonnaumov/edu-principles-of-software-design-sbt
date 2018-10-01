package ru.psd.junit;

import org.junit.*;
import java.util.*;

import static org.junit.Assert.*;

public class RectangleTest {
    private static final Map<Object, Double> calculateAreaData = new HashMap<Object, Double>();

    @Before
    public void setUp() {
        calculateAreaData.put(new Rectangle(10,10), 100d);
        calculateAreaData.put(new Rectangle(0,10), 0d);
        calculateAreaData.put(new Rectangle(10, 0.3), 3d);
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