package leetcode.hard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LC3841_PalindromicPathQueriesInATree {
    public static void main(String[] args) {
        LC3841_PalindromicPathQueriesInATree lc = new LC3841_PalindromicPathQueriesInATree();

        int n = 3;
        int[][] edges = {{0,1}, {1,2}};
        String s = "aac";
        String[] queries = {"query 0 2", "update 1 b", "query 0 2"};

        System.out.println(lc.palindromePath(n, edges, s, queries));
    }

    List<Integer>[] graph;

    int[] parent, depth, size, heavy;
    int[] head, pos, inverse;
    int[] value, tree;

    int timer;

//  Time Complexity - O(n + Q log^2 n)
    public List<Boolean> palindromePath(int n, int[][] edges, String s, String[] queries) {

        graph = new ArrayList[n];

        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int[] e : edges) {
            graph[e[0]].add(e[1]);
            graph[e[1]].add(e[0]);
        }

        parent = new int[n];
        depth = new int[n];
        size = new int[n];
        heavy = new int[n];

        Arrays.fill(heavy, -1);

        value = new int[n];

        for (int i = 0; i < n; i++) {
            value[i] = 1 << (s.charAt(i) - 'a');
        }

        dfs(0, -1);

        head = new int[n];
        pos = new int[n];
        inverse = new int[n];

        timer = 0;

        decompose(0, 0);

        tree = new int[4 * n];

        build(1, 0, n - 1);

        List<Boolean> ans = new ArrayList<>();

        for (String q : queries) {

            String[] parts = q.split(" ");

            if (parts[0].equals("update")) {

                int node = Integer.parseInt(parts[1]);
                char c = parts[2].charAt(0);

                int mask = 1 << (c - 'a');

                value[node] = mask;

                update(1, 0, n - 1, pos[node], mask);

            } else {

                int u = Integer.parseInt(parts[1]);
                int v = Integer.parseInt(parts[2]);

                int mask = queryPath(u, v);

                boolean possible = mask == 0 || (mask & (mask - 1)) == 0;

                ans.add(possible);
            }
        }

        return ans;
    }

    private void dfs(int node, int par) {

        parent[node] = par == -1 ? node : par;
        size[node] = 1;

        int maxSize = 0;

        for (int next : graph[node]) {

            if (next == par) continue;

            depth[next] = depth[node] + 1;

            dfs(next, node);

            size[node] += size[next];

            if (size[next] > maxSize) {
                maxSize = size[next];
                heavy[node] = next;
            }
        }
    }

    private void decompose(int node, int chainHead) {

        head[node] = chainHead;

        pos[node] = timer;
        inverse[timer] = node;

        timer++;

        if (heavy[node] != -1) {
            decompose(heavy[node], chainHead);
        }

        for (int next : graph[node]) {

            if (next == parent[node] || next == heavy[node]) {
                continue;
            }

            decompose(next, next);
        }
    }

    private void build(int node, int left, int right) {

        if (left == right) {
            tree[node] = value[inverse[left]];
            return;
        }

        int mid = (left + right) / 2;

        build(node * 2, left, mid);
        build(node * 2 + 1, mid + 1, right);

        tree[node] = tree[node * 2] ^ tree[node * 2 + 1];
    }

    private void update(int node, int left, int right, int index, int val) {
        if (left == right) {
            tree[node] = val;
            return;
        }

        int mid = (left + right) / 2;

        if (index <= mid) {
            update(node * 2, left, mid, index, val);
        } else {
            update(node * 2 + 1, mid + 1, right, index, val);
        }

        tree[node] = tree[node * 2] ^ tree[node * 2 + 1];
    }

    private int query(int node, int left, int right, int ql, int qr) {
        if (ql <= left && right <= qr) {
            return tree[node];
        }

        int mid = (left + right) / 2;

        int result = 0;

        if (ql <= mid) {
            result ^= query(node * 2, left, mid, ql, qr);
        }

        if (qr > mid) {
            result ^= query(node * 2 + 1, mid + 1, right, ql, qr);
        }

        return result;
    }

    private int queryPath(int u, int v) {
        int result = 0;

        while (head[u] != head[v]) {
            if (depth[head[u]] < depth[head[v]]) {
                int temp = u;
                u = v;
                v = temp;
            }

            result ^= query(1, 0, value.length - 1, pos[head[u]], pos[u]);

            u = parent[head[u]];
        }

        if (depth[u] > depth[v]) {
            int temp = u;
            u = v;
            v = temp;
        }

        result ^= query(1, 0, value.length - 1, pos[u], pos[v]);

        return result;
    }
}
