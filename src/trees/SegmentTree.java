package trees;

public class SegmentTree {
    public class Node{
        int data;
        int startInterval;
        int endInterval;
        Node left;
        Node right;

        public Node(int startInterval, int endInterval){
            this.startInterval = startInterval;
            this.endInterval = endInterval;
        }
    }

    protected Node root;

    public SegmentTree(int[] nums){
        this.root = insert(nums, 0, nums.length - 1);
    }

    public Node insert(int[] nums, int s, int e){
        if(s == e){
            Node leaf = new Node(s, e);
            leaf.data = nums[s];
            return leaf;
        }

        Node node = new Node(s, e);

        int mid = s + (e - s)/2;

        node.left = insert(nums, s, mid);
        node.right = insert(nums, mid + 1, e);

        node.data = node.left.data + node.right.data;
        return node;
    }

    public void display(){
        display(root, "Root Node: ");
    }

    private void display(Node node, String d){
        if(node == null){
            return;
        }

        System.out.println(d + node.data + " | index [" + node.startInterval + ", " + node.endInterval + "]");

        display(node.left, "Left Node Of " + node.data + " : ");
        display(node.right,  "Right Node of " + node.data + " : ");
    }

    public int query(int qsi, int qei){
        return query(root, qsi, qei);
    }

    private int query(Node node, int qsi, int qei){
        if(node.startInterval >= qsi && node.endInterval <= qei){
            return node.data;
        }else if(node.startInterval > qei || node.endInterval < qsi){
            return 0;
        }else {
            return query(node.left, qsi, qei) + query(node.right, qsi, qei);
        }
    }

    public void update(int index, int value){
        root.data = update(root, index, value);
    }

    public int update(Node node, int index, int value){
        if(index >= node.startInterval && index <= node.endInterval){
            if(index == node.startInterval && index == node.endInterval){
                node.data = value;
                return node.data;
            }else{
                int leftAns = update(node.left, index, value);
                int rightAns = update(node.right, index, value);

                node.data = leftAns + rightAns;

                return node.data;
            }
        }else{
            return node.data;
        }
    }

    public static void main(String[] args) {
        int[] arr = {2,4,5,7,8,9};
        SegmentTree st = new SegmentTree(arr);

        st.display();

        st.update(2, 10);
        System.out.println();
        st.display();
    }
}
