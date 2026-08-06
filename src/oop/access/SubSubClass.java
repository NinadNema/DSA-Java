package oop.access;

public class SubSubClass extends SubClass {

    public SubSubClass(int num, String name) {
        super(num, name);
    }

    public static void main(String[] args) {

        SubSubClass obj = new SubSubClass(50, "Amit");

        System.out.println(obj.getNum());
    }
}