package leetcode.hard;

public class LC25_ReverseNodeskGroup {
    public static void main(String[] args) {
        LC25_ReverseNodeskGroup lc = new LC25_ReverseNodeskGroup();

        lc.insert(1);
        lc.insert(2);
        lc.insert(3);
        lc.insert(4);
        lc.insert(5);

        lc.reverseKGroup(lc.head, 2);

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

    public ListNode reverseKGroup(ListNode head, int k) {
        if(head == null || k == 1){
            return head;
        }
        ListNode temp = head;

        for (int i = 0; i < k; i++) {
            if(temp == null){
                return head;
            }
            temp = temp.next;
        }

        ListNode prev = null;
        ListNode cur = head;

        for (int i = 0; i < k; i++) {
            ListNode next = cur.next;

            cur.next = prev;
            prev = cur;
            cur = next;
        }

        head.next = reverseKGroup(cur, k);

        return prev;
    }
}
