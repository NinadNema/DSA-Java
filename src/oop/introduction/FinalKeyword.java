package oop.introduction;

class StudentData {

    final int rollNo;

    StudentData(int rollNo) {
        this.rollNo = rollNo;
    }

    void display() {
        System.out.println("Roll No : " + rollNo);
    }
}

public class FinalKeyword {

    public static void main(String[] args) {

        StudentData student = new StudentData(101);

        student.display();

        // student.rollNo = 10; // Compilation Error
    }
}