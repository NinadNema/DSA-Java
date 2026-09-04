package leetcode.medium;

import java.util.*;

public class LC103_BinaryTreeZigzagLevelOrderTraversal {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if(root == null){
            return result;
        }

        Deque<TreeNode> deque = new ArrayDeque<>();
        deque.offer(root);

        boolean revese = false;
        while(!deque.isEmpty()){
            int level = deque.size();
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < level; i++) {

                if(!revese){
                    TreeNode current = deque.pollFirst();
                    list.add(current.val);

                    if(current.left != null){
                        deque.addLast(current.left);
                    }
                    if(current.right != null){
                        deque.addLast(current.right);
                    }
                }else{
                    TreeNode current = deque.pollLast();
                    list.add(current.val);

                    if(current.right != null){
                        deque.addFirst(current.right);
                    }
                    if(current.left != null){
                        deque.addFirst(current.left);
                    }
                }
            }
            revese = !revese;
            result.add(list);
        }
        return result;
    }
}
