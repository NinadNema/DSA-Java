package oop.inheritance;

public class Main {

    public static void main(String[] args) {

        System.out.println("Box");

        Box box = new Box(4, 5, 6);

        box.display();

        System.out.println("Volume : " + box.volume());

        System.out.println();

        System.out.println("BoxWeight");

        BoxWeight bw = new BoxWeight(4, 5, 6, 10);

        bw.display();

        System.out.println("Volume : " + bw.volume());

        System.out.println();

        System.out.println("BoxPrice");

        BoxPrice bp = new BoxPrice(4, 5, 6, 10, 1500);

        bp.display();

        System.out.println("Volume : " + bp.volume());
    }
}