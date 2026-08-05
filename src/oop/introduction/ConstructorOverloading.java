package oop.introduction;

public class ConstructorOverloading {

    int rollNo;
    String name;
    float marks;

    // Default Constructor
    ConstructorOverloading() {
        this(0, "Unknown", 0.0f);
    }

    // Constructor with all fields
    ConstructorOverloading(int rollNo, String name, float marks) {
        this.rollNo = rollNo;
        this.name = name;
        this.marks = marks;
    }

    // Constructor with only name
    ConstructorOverloading(String name) {
        this(0, name, 0.0f);
    }

    void display() {
        System.out.println("Roll No : " + rollNo);
        System.out.println("Name    : " + name);
        System.out.println("Marks   : " + marks);
        System.out.println();
    }

    public static void main(String[] args) {

        ConstructorOverloading s1 = new ConstructorOverloading();

        ConstructorOverloading s2 = new ConstructorOverloading(101, "Ninad", 95.5f);

        ConstructorOverloading s3 = new ConstructorOverloading("Rahul");

        s1.display();
        s2.display();
        s3.display();
    }
}