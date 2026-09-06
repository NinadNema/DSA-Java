package trees;

public class AVLTree {
    public static class Node{
        int val;
        Node left;
        Node right;
        int height;

        public Node(int val){
            this.val = val;
        }
    }

    protected Node root;

    public AVLTree(){

    }

    public boolean isEmpty(){
        return root == null;
    }

    public int height(){
        return height(root);
    }

    private int height(Node node){
        if(node == null){
            return -1;
        }

        return node.height;
    }

    public boolean isBalance(){
        return isBalance(root);
    }

    private boolean isBalance(Node node){
        if(node == null){
            return true;
        }

        return Math.abs(height(node.left) - height(node.right)) <= 1 && isBalance(node.right) && isBalance(node.left);
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
        return rotate(node);
    }

    private Node rotate(Node node){
        if(height(node.left) - height(node.right) > 1){
            //Left Heavy
            if(height(node.left.left) - height(node.left.right) > 0){
                //Left - Left Rotate
                return rightRotate(node);
            }
            if(height(node.left.left) - height(node.left.right) < 0){
                //Left - Right Rotate
                node.left = leftRotate(node.left);
                return rightRotate(node);
            }
        }

        if(height(node.left) - height(node.right) < -1){
            //Right Heavy
            if(height(node.right.left) - height(node.right.right) < 0){
                //Right - Right Rotate
                return leftRotate(node);
            }
            if(height(node.right.left) - height(node.right.right) > 0){
                //Right - Left Rotate
                node.right = rightRotate(node.right);
                return leftRotate(node);
            }
        }
        return node;
    }

    private Node leftRotate(Node c){
        Node p = c.right;
        Node t = p.left;

        p.left = c;
        c.right = t;

        p.height = Math.max(height(p.left), height(p.right)) + 1;
        c.height = Math.max(height(c.left), height(c.right)) + 1;

        return p;
    }

    private Node rightRotate(Node p) {
        Node c = p.left;
        Node t = c.right;

        c.right = p;
        p.left = t;

        p.height = Math.max(height(p.left), height(p.right)) + 1;
        c.height = Math.max(height(c.left), height(c.right)) + 1;

        return c;
    }

    public void display(){
        display(this.root, "Root Node: ");
    }

    private void display(Node node, String detail){
        if(node == null){
            return;
        }

        System.out.println(detail + node.val);

        display(node.left, "Left Node of " + node.val + " : ");
        display(node.right, "Right Node of " + node.val + " : ");
    }

    public void populate(int[] nums){
        for (int num : nums) {
            this.insert(num);
        }
    }


    public static void main(String[] args) {
        AVLTree avl = new AVLTree();

        for (int i = 0; i <= 500; i++) {
            avl.insert(i);
        }

        System.out.println(avl.height());
        avl.display();
    }
}