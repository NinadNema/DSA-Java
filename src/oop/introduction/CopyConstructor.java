package oop.introduction;

public class CopyConstructor {

    int rollNo;
    String name;
    float marks;

    CopyConstructor(int rollNo, String name, float marks) {
        this.rollNo = rollNo;
        this.name = name;
        this.marks = marks;
    }

    // Copy Constructor
    CopyConstructor(CopyConstructor other) {
        this.rollNo = other.rollNo;
        this.name = other.name;
        this.marks = other.marks;
    }

    void display() {
        System.out.println("Roll No : " + rollNo);
        System.out.println("Name    : " + name);
        System.out.println("Marks   : " + marks);
        System.out.println();
    }

    public static void main(String[] args) {

        CopyConstructor s1 = new CopyConstructor(101, "Ninad", 95.5f);

        CopyConstructor s2 = new CopyConstructor(s1);

        s1.display();
        s2.display();
    }
}