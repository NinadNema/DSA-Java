package leetcode.hard;

import java.util.Arrays;

public class LC3525_FindXValueOfArrayII {
    public static void main(String[] args) {
        LC3525_FindXValueOfArrayII lc = new LC3525_FindXValueOfArrayII();

        int[] nums = {1,2,4,8,16,32};
        int k = 3;
        int[][] q = {{0,2,0,2}, {0,2,0,1}};

        System.out.println(Arrays.toString(lc.resultArray(nums, k, q)));
    }

    static class Node {
        int product;
        int[] pref;

        Node(int k) {
            pref = new int[k];
        }
    }

    private Node[] tree;
    private int k;

//  Method 1: Time Complexity - O(nk)
    public int[] resultArray(int[] nums, int k, int[][] queries) {
        this.k = k;

        int n = nums.length;
        tree = new Node[4 * n];

        build(1, 0, n - 1, nums);

        int[] answer = new int[queries.length];

        for (int i = 0; i < queries.length; i++) {

            int index = queries[i][0];
            int value = queries[i][1];
            int start = queries[i][2];
            int x = queries[i][3];

            update(1, 0, n - 1, index, value);

            Node result = query(1, 0, n - 1, start, n - 1);

            answer[i] = result.pref[x];
        }

        return answer;
    }

    private void build(int node, int left, int right, int[] nums) {

        if (left == right) {
            tree[node] = new Node(k);

            int rem = nums[left] % k;

            tree[node].product = rem;
            tree[node].pref[rem] = 1;

            return;
        }

        int mid = left + (right - left) / 2;

        build(node * 2, left, mid, nums);
        build(node * 2 + 1, mid + 1, right, nums);

        tree[node] = merge(tree[node * 2], tree[node * 2 + 1]);
    }

    private void update(int node, int left, int right,
                        int index, int value) {

        if (left == right) {

            tree[node] = new Node(k);

            int rem = value % k;

            tree[node].product = rem;
            tree[node].pref[rem] = 1;

            return;
        }

        int mid = left + (right - left) / 2;

        if (index <= mid) {
            update(node * 2, left, mid, index, value);
        } else {
            update(node * 2 + 1, mid + 1, right, index, value);
        }

        tree[node] = merge(tree[node * 2], tree[node * 2 + 1]);
    }

    private Node merge(Node left, Node right) {

        Node parent = new Node(k);

        parent.product = (left.product * right.product) % k;

        for (int r = 0; r < k; r++) {
            parent.pref[r] += left.pref[r];
        }

        for (int r = 0; r < k; r++) {
            int newRemainder = (left.product * r) % k;
            parent.pref[newRemainder] += right.pref[r];
        }

        return parent;
    }

    private Node query(int node, int left, int right,
                       int ql, int qr) {

        if (ql <= left && right <= qr) {
            return tree[node];
        }

        int mid = left + (right - left) / 2;

        if (qr <= mid) {
            return query(node * 2, left, mid, ql, qr);
        }

        if (ql > mid) {
            return query(node * 2 + 1, mid + 1, right, ql, qr);
        }

        Node leftResult =
                query(node * 2, left, mid, ql, qr);

        Node rightResult =
                query(node * 2 + 1, mid + 1, right, ql, qr);

        return merge(leftResult, rightResult);
    }


//  Method 2: Time Complexity - O(n^2)
    public int[] resultArray2(int[] nums, int k, int[][] queries) {
        int[] result = new int[queries.length];

        for(int i = 0; i < queries.length; i++){
            int[] q = queries[i];

            nums[q[0]] = q[1];

            int suffixProd = 1;
            int count = 0;

            for(int j = q[2]; j < nums.length; j++){
                suffixProd = (suffixProd * (nums[j] % k)) % k;

                if(suffixProd == q[3]){
                    count++;
                }
            }

            result[i] = count;
        }

        return result;
    }
}
