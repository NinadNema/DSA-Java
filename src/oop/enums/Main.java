package oop.enums;

public class Main {

    public static void main(String[] args) {

        Week today = Week.SATURDAY;

        switch (today) {

            case MONDAY -> System.out.println("Study");

            case TUESDAY -> System.out.println("Practice");

            case WEDNESDAY -> System.out.println("Assignments");

            case THURSDAY -> System.out.println("Projects");

            case FRIDAY -> System.out.println("Revision");

            case SATURDAY -> System.out.println("LeetCode");

            case SUNDAY -> System.out.println("Rest");
        }
    }
}