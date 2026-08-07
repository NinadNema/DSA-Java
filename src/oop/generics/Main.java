package oop.generics;

public class Main {

    public static void main(String[] args) {

        CustomArrayList list = new CustomArrayList();

        list.add(10);
        list.add(20);
        list.add(30);

        System.out.println(list);

        GenericArrayList<String> names =
                new GenericArrayList<>();

        names.add("Ninad");
        names.add("Rahul");
        names.add("Amit");

        System.out.println(names);
    }
}