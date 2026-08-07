package oop.cloning;

public class ShallowCopy {

    public static void main(String[] args) throws CloneNotSupportedException {

        Human h1 = new Human(21,"Ninad");

        Human h2 = h1.clone();

        h2.marks[0] = 100;

        System.out.println(h1);

        System.out.println(h2);
    }
}