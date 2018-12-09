package ru.psd.junit;

import org.junit.*;

public class SquareTest extends ShapeTest {
    @Before
    public void setUp() {
        calculateAreaData.put(new Square(10), 100d);
        calculateAreaData.put(new Square(0.3d), 0.09d);
        calculateAreaData.put(new Square(0), 0d);
    }
}