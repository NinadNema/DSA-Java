package leetcode.easy;

import java.util.LinkedList;
import java.util.Queue;

public class LC543_DiameterOfBinaryTree {
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

//  Time Complexity - O(n)
    static int diameter = 0;
    public static int diameterOfBinaryTree(TreeNode root) {
        helper(root);
        return diameter - 1;
    }

    private static int helper(TreeNode node){
        if(node == null){
            return 0;
        }

        int leftHeight = helper(node.left);
        int rightHeight = helper(node.right);

        int dia = leftHeight + rightHeight + 1;
        diameter = Math.max(diameter, dia);

        return Math.max(leftHeight, rightHeight) + 1;
    }
}
