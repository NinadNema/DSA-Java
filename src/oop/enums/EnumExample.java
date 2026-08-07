package oop.enums;

public class EnumExample {

    enum Coffee {

        SMALL(100),
        MEDIUM(150),
        LARGE(200);

        private final int price;

        Coffee(int price) {
            this.price = price;
        }

        public int getPrice() {
            return price;
        }
    }

    public static void main(String[] args) {

        Coffee coffee = Coffee.LARGE;

        System.out.println(coffee);

        System.out.println(coffee.getPrice());

        for (Coffee c : Coffee.values()) {

            System.out.println(c + " : " + c.getPrice());
        }
    }
}