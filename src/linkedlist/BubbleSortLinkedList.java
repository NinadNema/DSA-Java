package linkedlist;

public class BubbleSortLinkedList {
    public static void main(String[] args) {
        BubbleSortLinkedList bs = new BubbleSortLinkedList();

        bs.insert(2);
        bs.insert(3);
        bs.insert(1);
        bs.insert(4);

        bs.bubbleSort();
    }

    private class Node{
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

    public void bubbleSort(){
        Node current;
        Node end = null;
        while(end != head){
            current = head;
            while(current.next != end){
                if(current.val > current.next.val){
                    int temp = current.val;
                    current.val = current.next.val;
                    current.next.val = temp;
                }
                current = current.next;
            }
            end = current;
        }
        display();
    }
}
