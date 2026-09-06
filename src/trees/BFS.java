package trees;

import java.util.*;

public class BFS{
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

    protected TreeNode root;

    public void insert(int[] arr) {
        if (arr == null || arr.length == 0) {
            return;
        }

        root = new TreeNode(arr[0]);

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        int i = 1;

        while (i < arr.length) {
            TreeNode current = queue.poll();

            if (i < arr.length) {
                current.left = new TreeNode(arr[i++]);
                queue.offer(current.left);
            }

            if (i < arr.length) {
                current.right = new TreeNode(arr[i++]);
                queue.offer(current.right);
            }
        }
    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if(root == null){
            return result;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()){
            int levelSize = queue.size();
            List<Integer> list = new ArrayList<>(levelSize);
            for (int i = 0; i < levelSize; i++) {
                TreeNode currentNode = queue.poll();
                list.add(currentNode.val);
                if(currentNode.left != null){
                    queue.offer(currentNode.left);
                }
                if(currentNode.right != null){
                    queue.offer(currentNode.right);
                }
            }
            result.add(list);
        }
        return result;
    }

    public TreeNode findSuccessor(TreeNode root, int val){
        if(root == null){
            return null;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while(!queue.isEmpty()){
            TreeNode current = queue.poll();
            if(current.left != null){
                queue.add(current.left);
            }
            if(current.right != null){
                queue.add((current.right));
            }
            if(current.val == val){
                break;
            }
        }

        return queue.peek();
    }

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if(root == null){
            return result;
        }

        Deque<TreeNode> deque = new ArrayDeque<>();
        deque.offer(root);

        boolean reverse = false;
        while(!deque.isEmpty()){
            int level = deque.size();
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < level; i++) {
                if(!reverse){
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
            reverse = !reverse;
            result.add(list);
        }
        return result;
    }

    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if(root == null){
            return result;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()){
            int levelSize = queue.size();
            List<Integer> list = new ArrayList<>(levelSize);
            for (int i = 0; i < levelSize; i++) {
                TreeNode currentNode = queue.poll();
                list.add(currentNode.val);
                if(currentNode.left != null){
                    queue.offer(currentNode.left);
                }
                if(currentNode.right != null){
                    queue.offer(currentNode.right);
                }
            }
            result.add(0, list);
        }
        return result;
    }

    public static void main(String[] args) {
        BFS bf = new BFS();
        int[] nums = {3,9,20,15,7};
        bf.insert(nums);

//        System.out.println(bf.zigzagLevelOrder(bf.root));
//        System.out.println(bf.levelOrder(bf.root));
        System.out.println(bf.levelOrderBottom(bf.root));
    }
}
