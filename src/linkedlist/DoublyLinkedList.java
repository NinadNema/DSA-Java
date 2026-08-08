package linkedlist;

public class DoublyLinkedList {
    private Node head;
    private Node tail;

    private int size;

    public DoublyLinkedList() { this.size = 0; }

    public int getSize() { return size; }

    private static class Node{
        private final int data;
        private Node next;
        private Node prev;

        public Node(int data) {
            this.data = data;
        }
    }

    public void insertBegin(int data){
        Node newNode = new Node(data);

        newNode.next = head;
        newNode.prev = null;
        if(head  != null) {
            head.prev = newNode;
        }
        head = newNode;

        if(tail == null){
            tail = newNode;
        }

        size++;
    }

    public void insertEnd(int data){
        Node newNode = new Node(data);

        if(tail == null){
            insertBegin(data);
            return;
        }

        newNode.prev = tail;
        tail.next = newNode;
        newNode.next = null;
        tail = newNode;

        size++;
    }

    public void insertPosition(int data, int idx){
        if (idx < 0 || idx > size) {
            throw new IndexOutOfBoundsException("Invalid index");
        }

        Node newNode = new Node(data);

        if(idx == 0){
            insertBegin(data);
            return;
        }

        if(idx == size){
            insertEnd(data);
            return;
        }

        Node temp = get(idx - 1);

        newNode.prev = temp;
        newNode.next = temp.next;
        temp.next.prev = newNode;
        temp.next = newNode;

        size++;
    }

    public int deleteBegin(){
        int val = head.data;

        if(head == tail){
            head = tail = null;
        }else {
            head = head.next;
            head.prev = null;
        }
        size--;
        return val;
    }

    public int deleteEnd(){
        int val = tail.data;
        if(head == tail){
            head = tail = null;
        }else {
            tail = tail.prev;
            tail.next = null;
        }

        size--;
        return val;
    }

    public int deletePosition(int idx){
        if (idx < 0 || idx > size) {
            throw new IndexOutOfBoundsException("Invalid index");
        }

        if(idx == 0){
            return deleteBegin();
        }

        if (idx == size - 1) {
            return deleteEnd();
        }

        Node temp = get(idx - 1);
        Node deleted = temp.next;

        int val = deleted.data;

        temp.next = deleted.next;
        deleted.next.prev = temp;

        deleted.prev = null;
        deleted.next = null;

        size--;
        return val;
    }

    public int find(int val){
        Node temp = head;
        int index = 0;

        while(temp != null){
            if(val == temp.data){
                return index;
            }
            temp = temp.next;
            index++;
        }

        return -1;
    }

    public Node get(int index){
        Node temp = head;

        for (int i = 0; i < index; i++) {
            temp = temp.next;
        }

        return temp;
    }

    public void display(){
        Node temp = head;

        while(temp != null){
            System.out.print(temp.data + " <-> ");
            temp = temp.next;
        }
        System.out.println("End");
    }

    public void displayRev(){
        Node temp = tail;

        while(temp != null){
            System.out.print(temp.data + " <-> ");
            temp = temp.prev;
        }
        System.out.println("Start");
    }
}
