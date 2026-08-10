package linkedlist;

import java.util.Scanner;

public class SinglyLinkedListDemo {
    public static void main(String[] args) {
        SinglyLinkedList ll = new SinglyLinkedList();

        Scanner sc = new Scanner(System.in);
        while(true) {
            System.out.println("1. Insert At Beginning");
            System.out.println("2. Insert At End");
            System.out.println("3. Insert At Specific Position");
            System.out.println("4. Delete From Beginning");
            System.out.println("5. Delete From End");
            System.out.println("6. Delete From Specific Position");
            System.out.println("7. Display the LinkedList");
            System.out.println("8. Size of LinkedList");
            System.out.println("9. Find the Value: ");
            System.out.println("10 Insertion At Specific Position Using Recursion: ");
            System.out.println("11. Exit");

            System.out.print("Enter Your Choice: ");
            int ch = sc.nextInt();

            switch (ch) {
                case 1: {
                    System.out.print("Enter the Data: ");
                    int data = sc.nextInt();
                    ll.insertionBegin(data);
                    break;
                }
                case 2: {
                    System.out.print("Enter the Data: ");
                    int data = sc.nextInt();
                    ll.insertEnd(data);
                    break;
                }
                case 3: {
                    System.out.print("Enter the Data: ");
                    int data = sc.nextInt();
                    System.out.print("Enter the Index to Insert: ");
                    int idx = sc.nextInt();
                    ll.insertionPosition(data, idx);
                    break;
                }
                case 4: {
                    System.out.println(ll.deleteBegin());
                    break;
                }
                case 5: {
                    System.out.println(ll.deleteEnd());
                    break;
                }
                case 6: {
                    System.out.print("Enter the Index to Delete: ");
                    int idx = sc.nextInt();
                    System.out.println(ll.deletePosition(idx));
                    break;
                }
                case 7: {
                    ll.display();
                    break;
                }
                case 8: {
                    System.out.print("The Size of LinkedList is " + ll.getSize());
                    break;
                }
                case 9: {
                    System.out.println("Enter the Value to Find on Index: ");
                    int val = sc.nextInt();
                    System.out.println("The Value at " + val + " is " + ll.find(val));
                    break;
                }
                case 10: {
                    System.out.print("Enter the Data: ");
                    int data = sc.nextInt();
                    System.out.print("Enter the Index to Insert: ");
                    int idx = sc.nextInt();
                    ll.insertRec(data, idx);
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
