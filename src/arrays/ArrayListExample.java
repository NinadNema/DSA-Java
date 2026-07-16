package arrays;

import java.util.ArrayList;
public class ArrayListExample {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();

        list.add(10);
        list.add(20);
        list.add(30);
        list.add(40);
        list.add(60);

        System.out.println(list.contains(20));
        System.out.println(list);
        System.out.println(list.set(0,99));
        System.out.println(list.remove(3));
    }
}
