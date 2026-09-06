package trees;

public class BinarySearchTree {
    public static class Node{
        int val;
        Node left;
        Node right;
        int height;

        public Node(int val){
            this.val = val;
        }

        public int getValue(){
            return val;
        }
    }

    protected Node root;

    public BinarySearchTree() {
    }

    public int height(Node node){
        if(node == null){
            return -1;
        }

        return node.height;
    }

    public boolean isEmpty(){
        return root == null;
    }

    public void insert(int value){
        root = insert(value, root);
    }

    private Node insert(int value, Node node){
        if(node == null){
            node = new Node(value);
            return node;
        }

        if(value < node.val){
            node.left = insert(value, node.left);
        }
        if(value > node.val){
            node.right = insert(value, node.right);
        }

        node.height = Math.max(height(node.left), height(node.right)) + 1;
        return node;
    }

    public boolean isBalanced(){
        return balance(root);
    }

    private boolean balance(Node node){
        if(node == null){
            return true;
        }
        return Math.abs(height(node.left) - height(node.right)) <= 1 && balance(node.left) && balance(node.right);
    }

    public void display(){
        display(root, "Root Node: ");
    }

    private void display(Node node, String d){
        if(node == null){
            return;
        }

        System.out.println(d + node.val);

        display(node.left, "Left Child of " + node.val + " : ");
        display(node.right, "Right Child of " + node.val + " : ");
    }

    public void populate(int[] nums){
        for (int num : nums) {
            this.insert(num);
        }
    }

    public void populateSorted(int[] nums){
        populateSorted(nums, 0, nums.length);
    }

    private void populateSorted(int[] nums, int start, int end){
        if(start >= end){
            return;
        }
        int mid = start + (end - start) / 2;
        this.insert(nums[mid]);
        populateSorted(nums, start, mid);
        populateSorted(nums, mid + 1, end);
    }

    public static void main(String[] args) {
        BinarySearchTree bst = new BinarySearchTree();
        TreeTraversal traversal = new TreeTraversal();

        int[] nums = {50, 30, 70, 20, 40, 60, 80, 10, 25, 35, 45};
        bst.populate(nums);
        bst.display();
        System.out.println();
        System.out.print("Pre Order Traversal: ");
        traversal.preOrder(bst.root);
        System.out.println();
        System.out.print("In Order Traversal: ");
        traversal.inOrder(bst.root);
        System.out.println();
        System.out.print("Post Order Traversal: ");
        traversal.postOrder(bst.root);
    }
}
