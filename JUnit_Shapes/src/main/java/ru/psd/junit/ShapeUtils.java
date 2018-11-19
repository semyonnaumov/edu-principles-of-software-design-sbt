package ru.psd.junit;

public class ShapeUtils {

    public static Shape max(Shape a, Shape b) {
        Double areaA = a.getArea();
        Double areaB = b.getArea();
        return areaA >= areaB ? a : b;
    }
}
