package linkedlist;

public class CircularLinkedList {

    private Node head;
    private Node tail;

    public CircularLinkedList() {
        this.tail = null;
        this.head = null;
    }

    public void insert(int data){
        Node newNode = new Node(data);

        if(head == null){
            head = newNode;
            tail = newNode;
            tail.next = head;
            return;
        }

        tail.next = newNode;
        tail = newNode;
        newNode.next = head;
    }

    public void delete(int val){
        Node temp = head;

        if(temp == null){
            return;
        }

        if(head == tail){
            head = null;
            tail = null;
            return;
        }

        if(temp.val == val){
            head = head.next;
            tail.next = head;
            return;
        }

        do{
            Node n = temp.next;

            if (n.val == val) {

                if (n == tail) {
                    tail = temp;
                }

                temp.next = n.next;
                tail.next = head;
                return;
            }

            temp = temp.next;

        }while(temp != head);
    }

    public void display(){
        Node temp = head;
        if(temp != null) {
            do {
                System.out.print(temp.val + " -> ");
                if(temp.next != null) {
                    temp = temp.next;
                }
            } while (temp != head);
        }
        System.out.println("HEAD");
    }

    private class Node{
        private int val;
        private Node next;

        public Node(int val) {
            this.val = val;
        }
    }
}
