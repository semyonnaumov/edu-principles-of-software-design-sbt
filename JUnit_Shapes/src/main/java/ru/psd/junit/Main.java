package ru.psd.junit;

public class Main {
    public static void main(String[] args) {
        Shape circle = new Circle(20);
        Shape rectangle = new Rectangle(20, 10);
        Shape square = new Square(15);

        System.out.println(circle.calculateArea());
        System.out.println(rectangle.calculateArea());
        System.out.println(square.calculateArea());
    }
}
