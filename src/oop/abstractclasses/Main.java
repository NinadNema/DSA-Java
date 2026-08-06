package oop.abstractclasses;

public class Main {

    public static void main(String[] args) {

        Parent.message();

        Parent son = new Son();

        son.greeting();
        son.career();
        son.partner();

        System.out.println();

        Parent daughter = new Daughter();

        daughter.greeting();
        daughter.career();
        daughter.partner();

        // Parent p = new Parent(); // ❌ Not Allowed
    }
}