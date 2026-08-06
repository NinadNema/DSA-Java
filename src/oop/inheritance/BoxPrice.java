package oop.inheritance;

public class BoxPrice extends BoxWeight {

    double price;

    BoxPrice(double length,
             double width,
             double height,
             double weight,
             double price) {

        super(length, width, height, weight);
        this.price = price;
    }

    void display() {
        super.display();
        System.out.println("Price  : " + price);
    }
}