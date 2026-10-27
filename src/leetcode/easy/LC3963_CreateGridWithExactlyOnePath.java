package leetcode.easy;

import java.util.Arrays;

public class LC3963_CreateGridWithExactlyOnePath {
    public static void main(String[] args) {
        LC3963_CreateGridWithExactlyOnePath lc = new LC3963_CreateGridWithExactlyOnePath();

        int m = 2;
        int n = 3;

        System.out.println(Arrays.toString(lc.createGrid(m, n)));
    }

//  Time Complexity - O(m x n)
    public String[] createGrid(int m, int n) {
        String[] grid = new String[m];

        for (int i = 0; i < m; i++) {
            StringBuilder row = new StringBuilder();

            for (int j = 0; j < n; j++) {
                if (i == 0 || j == n - 1) {
                    row.append('.');
                } else {
                    row.append('#');
                }
            }

            grid[i] = row.toString();
        }

        return grid;
    }
}
