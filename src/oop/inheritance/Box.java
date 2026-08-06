package oop.inheritance;

public class Box {

    double length;
    double width;
    double height;

    // Default Constructor
    Box() {
        this.length = -1;
        this.width = -1;
        this.height = -1;
    }

    // Cube
    Box(double side) {
        this.length = side;
        this.width = side;
        this.height = side;
    }

    // Parameterized Constructor
    Box(double length, double width, double height) {
        this.length = length;
        this.width = width;
        this.height = height;
    }

    // Copy Constructor
    Box(Box old) {
        this.length = old.length;
        this.width = old.width;
        this.height = old.height;
    }

    double volume() {
        return length * width * height;
    }

    void display() {
        System.out.println("Length : " + length);
        System.out.println("Width  : " + width);
        System.out.println("Height : " + height);
    }
}