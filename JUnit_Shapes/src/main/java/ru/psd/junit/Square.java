package ru.psd.junit;

public class Square implements Shape {
    private final double edge;

    public Square(double edge) {
        if ( edge < 0 ) {
            throw new WrongShapeParametersException("Shape dimensions must be not negative");
        } else {
            this.edge = edge;
        }
    }

    public double calculateArea() {
        return edge * edge;
    }
}
