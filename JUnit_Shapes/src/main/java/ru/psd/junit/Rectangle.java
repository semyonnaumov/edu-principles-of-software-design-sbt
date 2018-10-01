package ru.psd.junit;

public class Rectangle implements Shape {
    private final double width;
    private final double length;

    public Rectangle(double width, double length) {
        if (width < 0 || length < 0) {
            throw new WrongShapeParametersException("Shape dimensions must be not negative");
        } else {
            this.width = width;
            this.length = length;
        }

    }

    public double calculateArea() {
        return width * length;
    }
}
