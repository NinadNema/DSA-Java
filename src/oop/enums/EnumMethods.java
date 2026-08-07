package oop.enums;

public class EnumMethods {

    public static void main(String[] args) {

        Week day = Week.FRIDAY;

        System.out.println(day.ordinal());

        System.out.println(day.name());

        System.out.println(day);

        for (Week d : Week.values()) {

            System.out.println(d);
        }
    }
}