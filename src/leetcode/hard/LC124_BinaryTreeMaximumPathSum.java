package leetcode.hard;

public class LC124_BinaryTreeMaximumPathSum {
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

    int ans = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
       helper(root);
        return ans;
    }

    private int helper(TreeNode node){
        if(node == null){
            return 0;
        }

        int leftSum = helper(node.left);
        int rightSum = helper(node.right);

        leftSum = Math.max(0, leftSum);
        rightSum = Math.max(0, rightSum);

        int pathSum = leftSum + rightSum + node.val;

        ans = Math.max(ans, pathSum);

        return Math.max(leftSum, rightSum) + node.val;
    }
}
