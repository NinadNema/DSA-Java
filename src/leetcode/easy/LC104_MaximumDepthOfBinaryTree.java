package leetcode.easy;

public class LC104_MaximumDepthOfBinaryTree {
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

//  Time Complexity - O(n)
    public int maxDepth(TreeNode root) {
        return helper(root, 0);
    }

    private int helper(TreeNode node, int height){
        if(node == null){
            return height;
        }

        int heightLeft = helper(node.left, height + 1);
        int heightRight = helper(node.right, height + 1);


        return Math.max(heightLeft, heightRight);
    }
}
