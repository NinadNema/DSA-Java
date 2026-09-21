package leetcode.medium;

import java.util.LinkedList;
import java.util.Queue;

public class LC236_LowestCommonAncestorOfABinaryTree {
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

    public void insert(Integer[] arr) {
        if (arr == null || arr.length == 0 || arr[0] == null) {
            return;
        }

        root = new TreeNode(arr[0]);

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        int i = 1;

        while (i < arr.length) {
            TreeNode current = queue.poll();

            if (i < arr.length && arr[i] != null) {
                current.left = new TreeNode(arr[i]);
                queue.offer(current.left);
            }
            i++;

            if (i < arr.length && arr[i] != null) {
                current.right = new TreeNode(arr[i]);
                queue.offer(current.right);
            }
            i++;
        }
    }

    public TreeNode findNode(TreeNode root, int val) {
        if (root == null) {
            return null;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            TreeNode current = queue.poll();

            if (current.val == val) {
                return current;
            }

            if (current.left != null) {
                queue.offer(current.left);
            }

            if (current.right != null) {
                queue.offer(current.right);
            }
        }

        return null;
    }

//  Time Complexity - O(n)
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null){
            return null;
        }

        if(root == p || root == q){
            return root;
        }

        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        if(left != null && right != null){
            return root;
        }

        if(left == null){
            return right;
        }else{
            return left;
        }
    }

    public static void main(String[] args) {
        LC236_LowestCommonAncestorOfABinaryTree lc = new LC236_LowestCommonAncestorOfABinaryTree();

        Integer[] nums = {3,5,1,6,2,0,8,null,null,7,4};

        lc.insert(nums);

        TreeNode p = lc.findNode(lc.root, 5);
        TreeNode q = lc.findNode(lc.root, 1);

        System.out.println(lc.lowestCommonAncestor(lc.root,p, q).val);
    }
}
