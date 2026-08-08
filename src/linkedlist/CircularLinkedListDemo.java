package linkedlist;

import java.util.Scanner;

public class CircularLinkedListDemo {
    public static void main(String[] args) {
        CircularLinkedList cll = new CircularLinkedList();

        Scanner sc = new Scanner(System.in);

        while (true) {

            System.out.println("\n===== Circular Linked List =====");
            System.out.println("1. Insert");
            System.out.println("2. Delete");
            System.out.println("3. Display");
            System.out.println("4. Exit");

            System.out.print("Enter Choice: ");
            int ch = sc.nextInt();

            switch (ch) {

                case 1:
                    System.out.print("Enter Data: ");
                    int data = sc.nextInt();
                    cll.insert(data);
                    break;

                case 2:
                    System.out.print("Enter Value to Delete: ");
                    int val = sc.nextInt();
                    cll.delete(val);
                    break;

                case 3:
                    cll.display();
                    break;

                case 4:
                    System.out.println("Thank You!");
                    sc.close();
                    return;

                default:
                    System.out.println("Invalid Choice");
            }
        }
    }
}
