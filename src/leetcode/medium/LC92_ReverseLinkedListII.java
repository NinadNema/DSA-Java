package leetcode.medium;

public class LC92_ReverseLinkedListII {
    public static void main(String[] args) {
        LC92_ReverseLinkedListII lc = new LC92_ReverseLinkedListII();

        lc.insert(1);
        lc.insert(2);
        lc.insert(3);
        lc.insert(4);
        lc.insert(5);

        lc.display(lc.head);

        lc.reverseBetween(lc.head, 2, 4);

        lc.display(lc.head);
    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int val){
            this.val = val;
        }
    }

    private ListNode head = null;
    private ListNode tail = null;

    private void insert(int val){
        ListNode newNode = new ListNode(val);
        if(head == null){
            head = tail = newNode;
        }else{
            tail.next = newNode;
            tail = newNode;
        }
    }

    private void display(ListNode head){
        ListNode temp = head;
        while(temp != null){
            System.out.print(temp.val + " -> ");
            temp = temp.next;
        }
        System.out.println("END");
    }

    public ListNode reverseBetween(ListNode head, int left, int right) {
        if(left == right){
            return head;
        }

        ListNode current = head;
        ListNode prev = null;

        for (int i = 0; current != null && i < left - 1; i++) {
            prev = current;
            current = current.next;
        }

        ListNode last = prev;
        ListNode newEnd = current;

        ListNode next = current.next;
        for (int i = 0; current != null && i < right - left + 1; i++) {
            current.next = prev;
            prev = current;
            current = next;
            if(next != null){
                next = next.next;
            }
        }

        if(last != null){
            last.next = prev;
        }else{
            head = prev;
        }

        newEnd.next = current;

        return head;
    }
}
