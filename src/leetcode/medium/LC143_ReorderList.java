package leetcode.medium;

public class LC143_ReorderList {
    public static void main(String[] args) {
        LC143_ReorderList lc = new LC143_ReorderList();

        lc.insert(1);
        lc.insert(2);
        lc.insert(3);
        lc.insert(4);

        lc.display(lc.head);

        lc.reorderList(lc.head);

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

    public void reorderList(ListNode head) {
        if(head == null || head.next == null){
            return;
        }

        ListNode mid = getMid(head);
        ListNode headSecond = reverse(mid);
        ListNode headFirst = head;

        while(headSecond != null && headFirst != null){
            ListNode temp = headFirst.next;

            headFirst.next = headSecond;
            headFirst = temp;

            temp = headSecond.next;
            headSecond.next = headFirst;
            headSecond = temp;
        }

        if(headFirst != null){
            headFirst.next = null;
        }
    }

    public ListNode reverse(ListNode head){
        ListNode pres = head;
        ListNode prev = null;

        while(pres != null){
            ListNode next = pres.next;

            pres.next = prev;
            prev = pres;
            pres = next;
            if(next != null){
                next = next.next;
            }
        }

        return prev;
    }

    public ListNode getMid(ListNode head){
        ListNode s = head;
        ListNode f = head;

        while(f != null && f.next != null){
            s = s.next;
            f = f.next.next;
        }
        return s;
    }
}
