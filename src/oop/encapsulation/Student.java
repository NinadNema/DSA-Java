package oop.encapsulation;

public class Student {

    private int rollNo;
    private String name;
    private float marks;

    public Student(int rollNo, String name, float marks) {
        this.rollNo = rollNo;
        this.name = name;
        this.marks = marks;
    }

    public int getRollNo() {
        return rollNo;
    }

    public void setRollNo(int rollNo) {
        this.rollNo = rollNo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getMarks() {
        return marks;
    }

    public void setMarks(float marks) {
        if (marks >= 0 && marks <= 100) {
            this.marks = marks;
        } else {
            System.out.println("Invalid Marks");
        }
    }

    public void display() {
        System.out.println("Roll No : " + rollNo);
        System.out.println("Name    : " + name);
        System.out.println("Marks   : " + marks);
    }
}

class Main{
    public static void main(String[] args) {
        Student student = new Student(101, "Ninad", 95.5f);

        student.display();

        System.out.println();

        student.setMarks(99);

        student.display();

        System.out.println();

        student.setMarks(150);
    }
}