package trees;

public class TreeTraversal extends BinarySearchTree{
    protected void preOrder(Node node){
        if(node == null){
            return;
        }

        System.out.print(node.val + " ");
        preOrder(node.left);
        preOrder(node.right);
    }

    protected void inOrder(Node node){
        if(node == null){
            return;
        }

        inOrder(node.left);
        System.out.print(node.val + " ");
        inOrder(node.right);
    }

    protected void postOrder(Node node){
        if(node == null){
            return;
        }

        postOrder(node.left);
        postOrder(node.right);
        System.out.print(node.val + " ");
    }
}
