package leetcode.medium;

import java.util.List;
import java.util.ArrayList;

public class LC3310_RemoveMethodsFromProject {
    public static void main(String[] args) {
        int[][] invocations = {
                {1, 2},
                {0, 1},
                {3, 2}
        };

        System.out.println(remainingMethods(4, 1, invocations));
    }

//  Time Complexity - O(V+E) where V - n and E - invocations length
    static List<Integer> remainingMethods(int n, int k, int[][] invocations){

        List<Integer>[] graph = new ArrayList[n];

        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int[] edge : invocations) {
            graph[edge[0]].add(edge[1]);
        }


        boolean[] suspicious = new boolean[n];
        dfs(k, graph, suspicious);

        for (int[] edge : invocations) {

            int from = edge[0];
            int to = edge[1];

            if (!suspicious[from] && suspicious[to]) {

                List<Integer> ans = new ArrayList<>();

                for (int i = 0; i < n; i++) {
                    ans.add(i);
                }

                return ans;
            }
        }

        List<Integer> ans = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            if (!suspicious[i]) {
                ans.add(i);
            }
        }

        return ans;
    }

    static void dfs(int node, List<Integer>[] graph, boolean[] suspicious) {

        if (suspicious[node]) {
            return;
        }

        suspicious[node] = true;

        for (int next : graph[node]) {
            dfs(next, graph, suspicious);
        }
    }
}
