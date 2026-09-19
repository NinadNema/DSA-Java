package leetcode.easy;

public class LC108_ConvertSortedArrayToBinarySearchTree {
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

    TreeNode root;

    public TreeNode sortedArrayToBST(int[] nums) {
        return helper(nums, 0, nums.length);
    }

    private TreeNode helper(int[] nums, int s, int e){
        if(s >= e){
            return root;
        }

        int mid = s + (e - s) / 2;
        insert(nums[mid]);
        helper(nums, s, mid);
        helper(nums, mid + 1, e);

        return root;
    }

    public void insert(int value){
        root = insert(value, root);
    }

    private TreeNode insert(int value, TreeNode node){
        if(node == null){
            node = new TreeNode(value);
            return node;
        }

        if(value < node.val){
            node.left = insert(value, node.left);
        }
        if(value > node.val){
            node.right = insert(value, node.right);
        }

        return node;
    }
}
