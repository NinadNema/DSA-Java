package leetcode.hard;

public class LC297_SerializeAndDeserializeBinaryTree {
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

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        helper(root, sb);
        return sb.toString();
    }

    private void helper(TreeNode node, StringBuilder sb) {
        if (node == null) {
            sb.append("null ");
            return;
        }

        sb.append(node.val).append(" ");

        helper(node.left, sb);
        helper(node.right, sb);
    }

    // Decodes your encoded data to tree.
    private int index = 0;
    public TreeNode deserialize(String data) {
        String[] str = data.split(" ");
        index = 0;

        return helper1(str);
    }

    private TreeNode helper1(String[] str) {
        if (str[index].equals("null")) {
            index++;
            return null;
        }

        TreeNode node = new TreeNode(Integer.parseInt(str[index]));
        index++;

        node.left = helper1(str);
        node.right = helper1(str);

        return node;
    }
}
