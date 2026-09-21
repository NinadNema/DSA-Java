package leetcode.medium;

import java.util.ArrayList;

public class LC230_KthSmallestElementInABST {
     public class TreeNode {
         int val;
         TreeNode left;
         TreeNode right;

         TreeNode() {
         }

         TreeNode(int val) {
             this.val = val;
         }

         TreeNode(int val, TreeNode left, TreeNode right) {
             this.val = val;
             this.left = left;
             this.right = right;
         }
     }

//   Time Complexity - O(n)
    public int kthSmallest(TreeNode root, int k) {
        ArrayList<Integer> ans = new ArrayList<>();

        inOrder(root, ans);

        return ans.get(k - 1);
    }

    private void inOrder(TreeNode root, ArrayList<Integer> ans){
        if(root == null){
            return;
        }

        inOrder(root.left, ans);
        ans.add(root.val);
        inOrder(root.right, ans);
    }
}
