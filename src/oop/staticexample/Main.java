package oop.staticexample;

public class Main {

    public static void main(String[] args) {

        Human h1 = new Human("Ninad", 21);
        Human h2 = new Human("Rahul", 20);
        Human h3 = new Human("Amit", 22);

        h1.display();
        System.out.println();

        h2.display();
        System.out.println();

        System.out.println("Population : " + Human.population);
    }
}