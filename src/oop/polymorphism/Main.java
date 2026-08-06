package oop.polymorphism;

public class Main {
    public static void main(String[] args) {
        Shapes shapes = new Shapes();
        Shapes circle = new Circle();
        Shapes square = new Square();
        Shapes triangle = new Triangle();

        shapes.area();
        circle.area();
        square.area();
        triangle.area();
    }
}
