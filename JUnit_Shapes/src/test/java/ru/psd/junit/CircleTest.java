package ru.psd.junit;

import org.junit.*;

public class CircleTest extends ShapeTest {
    @Before
    public void setUp() {
        calculateAreaData.put(new Circle(1), Math.PI);
        calculateAreaData.put(new Circle(0.1), Math.PI*0.01);
        calculateAreaData.put(new Circle(0), 0d);
    }
}