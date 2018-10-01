package ru.psd.junit;

import org.junit.*;
import java.util.*;

import static org.junit.Assert.*;

public class CircleTest {
    private static final Map<Object, Double> calculateAreaData = new HashMap<Object, Double>();

    @Before
    public void setUp() {
        calculateAreaData.put(new Circle(1), Math.PI);
        calculateAreaData.put(new Circle(0.1), Math.PI*0.01);
        calculateAreaData.put(new Circle(0), 0d);
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