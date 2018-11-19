package ru.psd.junit;

import org.junit.Test;
import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;

public class ShapeTest {
    protected static final Map<Object, Double> calculateAreaData = new HashMap<Object, Double>();

    @Test
    public void calculateArea() {
        for (Map.Entry<Object, Double> entry : calculateAreaData.entrySet()) {
            final Shape testShape = (Shape)entry.getKey();
            final Double expected = entry.getValue();
            final Double actual = testShape.getArea();
            assertEquals(expected, actual);
        }
    }
}
