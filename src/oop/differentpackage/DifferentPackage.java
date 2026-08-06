package oop.differentpackage;

import oop.access.A;

public class DifferentPackage {

    public static void main(String[] args) {

        A obj = new A(1, "Java");

        System.out.println(obj.getNum());

        // obj.name No package-private

        // obj.num No private
    }
}