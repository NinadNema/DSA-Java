package oop.abstraction;

public class Main {

    public static void main(String[] args) {

        Parent son = new Son();

        son.greeting();
        son.career();
        son.partner();

        System.out.println();

        Parent daughter = new Daughter();

        daughter.greeting();
        daughter.career();
        daughter.partner();

//       Not Allowed
//       Parent p = new Parent();
    }
}