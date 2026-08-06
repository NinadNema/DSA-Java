package oop.access;

public class Main {

    public static void main(String[] args) {

        A obj = new A(10, "Ninad");

        obj.display();

        System.out.println(obj.getNum());

        obj.setNum(100);

        System.out.println(obj.getNum());
    }
}