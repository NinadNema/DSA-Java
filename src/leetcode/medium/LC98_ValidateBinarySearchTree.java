package leetcode.medium;

import java.util.LinkedList;
import java.util.Queue;

public class LC98_ValidateBinarySearchTree {
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

    public boolean isValidBST(TreeNode root){
        return helper(root, null, null);
    }

    public boolean helper(TreeNode root, Integer low, Integer high) {
        if(root == null){
            return true;
        }

        if(low != null && root.val <= low){
            return false;
        }

        if(high != null && root.val >= high){
            return false;
        }

        boolean left = helper(root.left, low, root.val);
        boolean right = helper(root.right, root.val, high);

        return left && right;
    }
}
