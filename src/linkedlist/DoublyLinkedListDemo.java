package linkedlist;

import java.util.Scanner;

public class DoublyLinkedListDemo {
    public static void main(String[] args) {
        DoublyLinkedList dll = new DoublyLinkedList();

        Scanner sc = new Scanner(System.in);
        while(true) {
            System.out.println("1. Insert At Beginning");
            System.out.println("2. Insert At End");
            System.out.println("3. Insert At Specific Position");
            System.out.println("4. Delete From Beginning");
            System.out.println("5. Delete From End");
            System.out.println("6. Delete From Specific Position");
            System.out.println("7. Display the LinkedList");
            System.out.println("8. Display LinkedList In Reverse");
            System.out.println("9. Size of LinkedList");
            System.out.println("10. Find the Value: ");
            System.out.println("11. Exit");

            System.out.print("Enter Your Choice: ");
            int ch = sc.nextInt();

            switch (ch) {
                case 1: {
                    System.out.print("Enter the Data: ");
                    int data = sc.nextInt();
                    dll.insertBegin(data);
                    break;
                }
                case 2: {
                    System.out.print("Enter the Data: ");
                    int data = sc.nextInt();
                    dll.insertEnd(data);
                    break;
                }
                case 3: {
                    System.out.print("Enter the Data: ");
                    int data = sc.nextInt();
                    System.out.print("Enter the Index to Insert: ");
                    int idx = sc.nextInt();
                    dll.insertPosition(data, idx);
                    break;
                }
                case 4: {
                    System.out.println(dll.deleteBegin());
                    break;
                }
                case 5: {
                    System.out.println(dll.deleteEnd());
                    break;
                }
                case 6: {
                    System.out.print("Enter the Index to Delete: ");
                    int idx = sc.nextInt();
                    System.out.println(dll.deletePosition(idx));
                    break;
                }
                case 7: {
                    dll.display();
                    break;
                }
                case 8: {
                    dll.displayRev();
                    break;
                }
                case 9: {
                    System.out.print("The Size of LinkedList is " + dll.getSize());
                    break;
                }
                case 10: {
                    System.out.println("Enter the Value to Find on Index: ");
                    int val = sc.nextInt();
                    System.out.println("The Value at " + val + " is " + dll.find(val));
                    break;
                }
                case 11: {
                    System.out.println("Thank You");
                    sc.close();
                    return;
                }
                default: {
                    System.out.println("Invalid Choice");
                }
            }
        }
    }
}
