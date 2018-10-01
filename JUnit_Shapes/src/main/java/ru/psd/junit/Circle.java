package ru.psd.junit;

public class Circle implements Shape {
    private final double radius;

    public Circle(double radius) {
        if ( radius < 0 ) {
            throw new WrongShapeParametersException("Shape dimensions must be not negative");
        } else {
            this.radius = radius;
        }
    }

    public double calculateArea() {
        return Math.PI * radius * radius;
    }
}
