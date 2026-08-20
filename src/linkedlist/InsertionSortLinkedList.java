package linkedlist;

public class InsertionSortLinkedList {
    public static void main(String[] args) {
        InsertionSortLinkedList is = new InsertionSortLinkedList();

        is.insert(2);
        is.insert(1);
        is.insert(3);
        is.insert(4);

        is.insertionSort();
    }

    private static class Node{
        int val;
        Node next;

        Node(int val){
            this.val = val;
        }
    }

    private Node head = null;
    private Node tail = null;

    private void insert(int val){
        Node newNode = new Node(val);
        if(head == null){
            head = tail = newNode;
        }else{
            tail.next = newNode;
            tail = newNode;
        }
    }

    private void display(){
        Node temp = head;
        while(temp != null){
            System.out.print(temp.val + " -> ");
            temp = temp.next;
        }
        System.out.println("END");
    }

    public void insertionSort(){
        Node sorted = null;
        Node current = head;
        while(current != null){
            Node next = current.next;

            if(sorted == null || current.val < sorted.val){
                current.next = sorted;
                sorted = current;
            }else{
                Node temp = sorted;

                while(temp.next != null && temp.next.val < current.val){
                    temp = temp.next;
                }

                current.next = temp.next;
                temp.next = current;
            }

            current = next;
        }
        head = sorted;

        display();
    }
}
