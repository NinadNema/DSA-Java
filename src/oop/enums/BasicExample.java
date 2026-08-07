package oop.enums;

public class BasicExample {

    public static void main(String[] args) {

        Week day = Week.MONDAY;

        System.out.println(day);

        if (day == Week.MONDAY) {
            System.out.println("Start of the Week");
        }
    }
}