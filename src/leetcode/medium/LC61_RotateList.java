package leetcode.medium;

public class LC61_RotateList {
    public static void main(String[] args) {
        LC61_RotateList lc = new LC61_RotateList();

        lc.insert(1);
        lc.insert(2);
        lc.insert(3);
        lc.insert(4);
        lc.insert(5);

        lc.head = lc.rotateRight(lc.head, 2);

        lc.display(lc.head);
    }

    protected static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
          val = x;
          next = null;
        }
    }

    private ListNode head = null;
    private ListNode tail = null;


    public void insert(int x){
        ListNode newNode = new ListNode(x);
        if(head == null){
            head = tail = newNode;
            return;
        }

        tail.next = newNode;
        tail = newNode;
    }

    public void display(ListNode head){
        ListNode temp = head;
        while(temp != null){
            System.out.print(temp.val + " -> ");
            temp = temp.next;
        }
        System.out.println("END");
    }

    public ListNode rotateRight(ListNode head, int k){
        if(head == null || head.next == null || k == 0){
            return head;
        }

        ListNode tail = head;
        int length = 1;

        while(tail.next != null){
            tail = tail.next;
            length++;
        }

        k = k % length;

        if(k == 0){
            return head;
        }

        tail.next = head;

        int step = length - k;
        ListNode newTail = head;

        for (int i = 1; i < step; i++) {
            newTail = newTail.next;
        }

        ListNode newHead = newTail.next;

        newTail.next = null;

        return newHead;
    }
}