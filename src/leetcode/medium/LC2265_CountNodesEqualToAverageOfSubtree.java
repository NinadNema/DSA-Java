package leetcode.medium;

import java.util.LinkedList;
import java.util.Queue;

public class LC2265_CountNodesEqualToAverageOfSubtree {
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

//   Time Complexity - O(n^2)
     public int averageOfSubtree(TreeNode root) {
         if(root == null){
             return 0;
         }

         Queue<TreeNode> q = new LinkedList<>();
         q.offer(root);

         int count = 0;
         int totalNode = 0;
         int sum = 0;

         while(!q.isEmpty()){
             int level = q.size();
             for (int i = 0; i < level; i++) {
                 TreeNode node = q.poll();
                 totalNode++;
                 sum += node.val;
                 if(node.left != null){
                     q.offer(node.left);
                 }
                 if(node.right != null){
                     q.offer(node.right);
                 }
             }
         }

         if(Math.abs(sum / totalNode) == root.val){
             count++;
         }

         count += averageOfSubtree(root.left);
         count += averageOfSubtree(root.right);

         return count;
     }
}
