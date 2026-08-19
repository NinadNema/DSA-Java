package leetcode.easy;

public class LC876_MiddleLinkedList {
    public static void main(String[] args) {
        LC876_MiddleLinkedList lc = new LC876_MiddleLinkedList();

        lc.insert(1);
        lc.insert(2);
        lc.insert(3);
        lc.insert(4);
        lc.insert(5);
        lc.insert(6);
        lc.insert(7);
        lc.insert(8);

        System.out.println(lc.middleNode(lc.head).val);
        System.out.println(lc.middleNode1(lc.head).val);
    }

    public class ListNode{
        int val;
        ListNode next;

        ListNode(int val){
            this.val = val;
        }
    }

    private ListNode head = null;

    private void insert(int val){
        ListNode newNode = new ListNode(val);
        if(head == null){
            head = newNode;
        }else{
            ListNode temp = head;
            while(temp.next != null){
                temp = temp.next;
            }
            temp.next = newNode;
        }
    }

//  Method 1: Calculate Length and Traverse the LinkedList by Length / 2
//  Time Complexity - O(n)
    public ListNode middleNode1(ListNode head){
        ListNode temp = head;
        int length = 0;
        while(temp != null){
            length++;
            temp = temp.next;
        }

        if(length % 2 == 0){
            for (int i = 0; i < length / 2; i++) {
                head = head.next;
            }
        }else {
            for (int i = 0; i < length / 2; i++) {
                head = head.next;
            }
        }
        return head;
    }

//  Method 2: Using Fast and Slow Pointer
//  Time Complexity - O(n)
    public ListNode middleNode(ListNode head){
        ListNode slow =  head;
        ListNode fast = head;

        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }
}
