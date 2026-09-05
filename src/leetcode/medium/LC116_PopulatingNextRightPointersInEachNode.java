package leetcode.medium;

import java.util.LinkedList;
import java.util.Queue;

public class LC116_PopulatingNextRightPointersInEachNode {
    class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    };

//  Method 1 : Efficient Method
//  Time complexity - O(n) Space Complexity - O(1)
    public Node connect(Node root){
        if(root == null){
            return null;
        }

        Node leftMost = root;
        while(leftMost.left != null){
            Node current = leftMost;
            while(current != null){
                current.left.next = current.right;
                if(current.next != null){
                    current.right.next = current.next.left;
                }
                current = current.next;
            }
            leftMost = leftMost.left;
        }

        return root;
    }


//  Method 2 : Using Queue
//  Time Complexity : O(n) Space Complexity - O(n)
    public Node connectQueue(Node root) {
        if(root == null){
            return root;
        }

        Queue<Node> q = new LinkedList<>();
        q.offer(root);

        while(!q.isEmpty()){
            int level = q.size();

            for (int i = 0; i < level; i++) {
                Node current = q.poll();

                if(i == level - 1){
                    current.next = null;
                }else {
                    current.next = q.peek();
                }
                if(current.left != null){
                    q.offer(current.left);
                }

                if(current.right != null){
                    q.offer(current.right);
                }
            }
        }
        return root;
    }
}
