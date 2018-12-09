package ru.psd.junit;

import org.junit.*;

public class RectangleTest extends ShapeTest {
    @Before
    public void setUp() {
        calculateAreaData.put(new Rectangle(10,10), 100d);
        calculateAreaData.put(new Rectangle(0,10), 0d);
        calculateAreaData.put(new Rectangle(10, 0.3), 3d);
    }
}