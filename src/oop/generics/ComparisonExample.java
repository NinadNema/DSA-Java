package oop.generics;

import java.util.Arrays;

public class ComparisonExample {

    public static void main(String[] args) {

        Student[] students = {
                new Student(3,"Rahul"),
                new Student(1,"Ninad"),
                new Student(2,"Amit")
        };

        Arrays.sort(students);

        System.out.println(Arrays.toString(students));
    }
}