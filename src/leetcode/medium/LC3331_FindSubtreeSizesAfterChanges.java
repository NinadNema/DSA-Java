package leetcode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LC3331_FindSubtreeSizesAfterChanges {
    public static void main(String[] args) {
        LC3331_FindSubtreeSizesAfterChanges lc = new LC3331_FindSubtreeSizesAfterChanges();

        int[] parent = new int[]{-1, 0, 0, 1, 1, 1};
        String s = "abaabc";

        System.out.println(Arrays.toString(lc.findSubtreeSizes(parent, s)));
    }

//  Time Complexity - O(n)
    public int[] findSubtreeSizes(int[] parent, String s) {
        int n = parent.length;

        List<Integer>[] tree = new ArrayList[n];

        for (int i = 0; i < n; i++) {
            tree[i] = new ArrayList<>();
        }

        for (int i = 1; i < n; i++) {
            tree[parent[i]].add(i);
        }

        int[] newParent = parent.clone();

        int[] last = new int[26];
        Arrays.fill(last, -1);

        dfs(0, tree, s, last, newParent);

        List<Integer>[] finalTree = new ArrayList[n];

        for (int i = 0; i < n; i++) {
            finalTree[i] = new ArrayList<>();
        }

        for (int i = 1; i < n; i++) {
            finalTree[newParent[i]].add(i);
        }

        int[] answer = new int[n];
        dfsSize(0, finalTree, answer);

        return answer;
    }

    private void dfs(int node, List<Integer>[] tree, String s, int[] last, int[] newParent) {
        int c = s.charAt(node) - 'a';

        int previous = last[c];

        if (previous != -1) {
            newParent[node] = previous;
        }

        last[c] = node;

        for (int child : tree[node]) {
            dfs(child, tree, s, last, newParent);
        }

        last[c] = previous;
    }

    private int dfsSize(int node, List<Integer>[] tree, int[] answer) {
        int size = 1;

        for (int child : tree[node]) {
            size += dfsSize(child, tree, answer);
        }

        answer[node] = size;

        return size;
    }
}
