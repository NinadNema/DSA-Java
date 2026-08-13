package leetcode.hard;

import java.util.Arrays;

public class LC2213_LongestSubstringOneRepeatingCharacter {
    public static void main(String[] args){
        LC2213_LongestSubstringOneRepeatingCharacter lc = new LC2213_LongestSubstringOneRepeatingCharacter();
        String s = "babacc";
        String queryCharacters = "bcb";
        int[]  queryIndices = {1,3,3};

        System.out.println(Arrays.toString(lc.longestRepeating(s, queryCharacters, queryIndices)));
    }

//  Time Complexity - O(n + k log n)
    static class Node {
        char leftChar;
        char rightChar;

        int prefix;
        int suffix;
        int best;
        int length;

        Node(char leftChar, char rightChar, int prefix, int suffix, int best, int length) {
            this.leftChar = leftChar;
            this.rightChar = rightChar;
            this.prefix = prefix;
            this.suffix = suffix;
            this.best = best;
            this.length = length;
        }
    }

    static Node[] tree;

    static void build(String s, int node, int left, int right) {

        if (left == right) {

            char ch = s.charAt(left);

            tree[node] = new Node(ch, ch, 1, 1, 1, 1);

            return;
        }

        int mid = left + (right - left) / 2;

        build(s, node * 2, left, mid);
        build(s, node * 2 + 1, mid + 1, right);

        tree[node] = merge(tree[node * 2], tree[node * 2 + 1]);
    }

    static Node merge(Node leftNode, Node rightNode) {
        Node result = new Node(leftNode.leftChar, rightNode.rightChar, 0, 0, 0, leftNode.length + rightNode.length);

        result.prefix = leftNode.prefix;

        if (leftNode.prefix == leftNode.length && leftNode.rightChar == rightNode.leftChar) {
            result.prefix = leftNode.length + rightNode.prefix;
        }

        result.suffix = rightNode.suffix;

        if (rightNode.suffix == rightNode.length && leftNode.rightChar == rightNode.leftChar) {
            result.suffix = rightNode.length + leftNode.suffix;
        }

        result.best = Math.max(leftNode.best, rightNode.best);

        if (leftNode.rightChar == rightNode.leftChar) {
            result.best = Math.max(result.best, leftNode.suffix + rightNode.prefix);
        }

        return result;
    }

    static void update(int node, int left, int right, int index, char ch) {
        if (left == right) {
            tree[node] = new Node(ch, ch, 1, 1, 1, 1);

            return;
        }

        int mid = left + (right - left) / 2;

        if (index <= mid) {
            update(node * 2, left, mid, index, ch);

        } else {
            update(node * 2 + 1, mid + 1, right, index, ch);
        }

        tree[node] = merge(tree[node * 2], tree[node * 2 + 1]);
    }

    public int[] longestRepeating(String s, String queryCharacters, int[] queryIndices) {

        int n = s.length();
        int k = queryIndices.length;

        tree = new Node[4 * n];

        build(s, 1, 0, n - 1);

        int[] answer = new int[k];

        for (int i = 0; i < k; i++) {

            int index = queryIndices[i];
            char ch = queryCharacters.charAt(i);

            update(1, 0, n - 1, index, ch);

            answer[i] = tree[1].best;
        }

        return answer;
    }
}
