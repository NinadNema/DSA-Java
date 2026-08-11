package leetcode.easy;

public class LC141_LinkedListCycle {
    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

//  Time Complexity - O(n)
    public boolean hasCycle(ListNode head) {
        ListNode s = head;
        ListNode f = head;

        while (f != null && f.next != null) {
            s = s.next;
            f = f.next.next;

            if (s == f) {
                return true;
            }
        }
        return false;
    }

    public int lengthCycle(ListNode head) {
        ListNode s = head;
        ListNode f = head;

        while (f != null && f.next != null) {
            s = s.next;
            f = f.next.next;

            if (s == f) {
                ListNode temp = s;
                int length = 0;
                do{
                    temp = temp.next;
                    length++;
                }while(temp != s);

                return length;
            }
        }
        return 0;
    }
}
