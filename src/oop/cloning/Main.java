package oop.cloning;

public class Main {

    public static void main(String[] args) throws CloneNotSupportedException {

        Human h1 = new Human(20,"Rahul");

        Human h2 = h1.clone();

        System.out.println(h1);

        System.out.println(h2);
    }
}