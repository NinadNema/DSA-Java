package oop.inheritance;

public class BoxWeight extends Box {

    double weight;

    BoxWeight() {
        this.weight = -1;
    }

    BoxWeight(double side, double weight) {
        super(side);
        this.weight = weight;
    }

    BoxWeight(double length, double width, double height, double weight) {
        super(length, width, height);
        this.weight = weight;
    }

    BoxWeight(BoxWeight other) {
        super(other);
        this.weight = other.weight;
    }

    void display() {
        super.display();
        System.out.println("Weight : " + weight);
    }
}