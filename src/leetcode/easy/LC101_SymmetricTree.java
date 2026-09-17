package leetcode.easy;

import java.util.LinkedList;
import java.util.Queue;

public class LC101_SymmetricTree {
    public class TreeNode {
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

    public boolean isSymmetric(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root.left);
        q.offer(root.right);

        while(!q.isEmpty()){
            TreeNode left = q.poll();
            TreeNode right = q.poll();

            if(left == null && right == null){
                continue;
            }

            if(left == null || right == null){
                return false;
            }

            if(left.val != right.val){
                return false;
            }

            q.offer(left.left);
            q.offer(right.right);
            q.offer(left.right);
            q.offer(right.left);
        }

        return true;
    }
}
