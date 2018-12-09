package ru.psd.junit;

import java.util.Comparator;

public class ShapeComparator implements Comparator<Shape> {
    public int compare(Shape o1, Shape o2) {
        double areaA = o1.getArea();
        double areaB = o2.getArea();

        double difference = Math.abs(areaA - areaB);
        if ( difference < 10e-6 ) {
            return 0;
        } else if ( areaA > areaB ) {
            return 1 + (int) difference;
        } else {
            return - 1 - (int) difference;
        }
    }
}
