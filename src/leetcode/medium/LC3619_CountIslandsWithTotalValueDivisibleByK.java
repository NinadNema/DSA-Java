package leetcode.medium;

import java.util.*;

public class LC3619_CountIslandsWithTotalValueDivisibleByK {
    public static void main(String[] args) {
        LC3619_CountIslandsWithTotalValueDivisibleByK lc = new LC3619_CountIslandsWithTotalValueDivisibleByK();

        int[][] grid = {{0,2,1,0,0}, {0,5,0,0,5}, {0,0,1,0,0}, {0,1,4,7,0}, {0,2,0,0,8}};
        int k = 5;

        System.out.println(lc.countIslands(grid, k));
    }

    public int countIslands(int[][] grid, int k) {
        int m = grid.length;
        int n = grid[0].length;

        int count = 0;

        int[] dr = {-1, 1, 0, 0};
        int[] dc = {0, 0, -1, 1};

        for (int r = 0; r < m; r++) {
            for (int c = 0; c < n; c++) {

                if (grid[r][c] == 0) continue;

                long sum = 0;

                Stack<int[]> stack = new Stack<>();
                stack.push(new int[]{r, c});
                sum += grid[r][c];
                grid[r][c] = 0;

                while (!stack.isEmpty()) {
                    int[] cell = stack.pop();

                    for (int d = 0; d < 4; d++) {
                        int nr = cell[0] + dr[d];
                        int nc = cell[1] + dc[d];

                        if (nr >= 0 && nr < m &&
                                nc >= 0 && nc < n &&
                                grid[nr][nc] > 0) {

                            sum += grid[nr][nc];
                            grid[nr][nc] = 0;

                            stack.push(new int[]{nr, nc});
                        }
                    }
                }

                if (sum % k == 0) {
                    count++;
                }
            }
        }

        return count;
    }
}
