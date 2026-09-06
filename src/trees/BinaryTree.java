package trees;

import java.util.Scanner;

public class BinaryTree {
    public static class Node{
        int value;
        Node left;
        Node right;

        public Node(int value){
            this.value = value;
        }
    }

    protected Node root;

    public void insert(Scanner sc){
        System.out.print("Enter the Root Node: ");
        int value = sc.nextInt();
        root = new Node(value);
        insert(root, sc);
    }

    private void insert(Node node, Scanner sc){
        System.out.print("Do you Want to Insert To left of " + node.value + ": ");
        boolean left = sc.nextBoolean();
        if(left){
            System.out.print("Enter the Value: ");
            int value = sc.nextInt();
            node.left = new Node(value);
            insert(node.left, sc);
        }

        System.out.print("Do you want to insert to right of " + node.value + ": ");
        boolean right = sc.nextBoolean();
        if(right){
            System.out.print("Enter the Value: ");
            int value = sc.nextInt();
            node.right = new Node(value);
            insert(node.right, sc);
        }
    }

    public void display(){
        display(root, 0);
    }

    private void display(Node node, int level){
        if(node == null){
            return;
        }

        display(node.right, level + 1);

        if(level != 0){
            for (int i = 0; i < level - 1; i++) {
                System.out.print("|\t\t");
            }
            System.out.println("|----->" + node.value);
        }else{
            System.out.println(node.value);
        }

        display(node.left, level + 1);
    }

    public static void main(String[] args) {
        BinaryTree bt = new BinaryTree();
        Scanner sc = new Scanner(System.in);
        bt.insert(sc);
        bt.display();
    }
}
