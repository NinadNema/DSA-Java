package leetcode.medium;

public class LC142_LinkedListCycleII {
    public static void main(String[] args) {
        LC142_LinkedListCycleII lc = new LC142_LinkedListCycleII();

        lc.insert(3);
        lc.insert(2);
        lc.insert(0);
        lc.insert(4);

        lc.cycle(lc.head);
        System.out.println(lc.detectCycle(lc.head).val);
    }

//  Time Complexity - O(n)

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
          val = x;
          next = null;
        }
    }

    public void cycle(ListNode head){
        tail.next = head.next;
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

    public void display(){
        ListNode temp = head;
        while(temp != null){
            System.out.print(temp.val + " -> ");
            temp = temp.next;
        }
        System.out.println();
    }

    public ListNode detectCycle(ListNode head) {
        ListNode s = head;
        ListNode f = head;

        while (f != null && f.next != null) {
            s = s.next;
            f = f.next.next;

            if (s == f) {
                ListNode temp = s;
                int length = 0;
                do {
                    temp = temp.next;
                    length++;
                } while (temp != s);

                ListNode first = head;
                ListNode second = head;

                while (length > 0) {
                    second = second.next;
                    length--;
                }

                while (first != second) {
                    first = first.next;
                    second = second.next;
                }
                return second;
            }
        }
        return null;
    }
}
