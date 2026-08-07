package oop.generics;

import java.util.ArrayList;
import java.util.List;

public class WildcardExample {

    static void printNumbers(List<? extends Number> list) {

        for (Number n : list) {
            System.out.println(n);
        }
    }

    public static void main(String[] args) {

        List<Integer> nums = new ArrayList<>();

        nums.add(10);
        nums.add(20);
        nums.add(30);

        printNumbers(nums);
    }
}