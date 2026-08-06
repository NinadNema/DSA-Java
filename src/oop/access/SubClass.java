package oop.access;

public class SubClass extends A {

    public SubClass(int num, String name) {
        super(num, name);
    }

    public static void main(String[] args) {

        SubClass obj = new SubClass(20, "Rahul");

        System.out.println(obj.getNum());

        // obj.num No private
    }
}