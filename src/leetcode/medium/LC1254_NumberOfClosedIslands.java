package leetcode.medium;

public class LC1254_NumberOfClosedIslands {
    public static void main(String[] args) {
        LC1254_NumberOfClosedIslands lc = new LC1254_NumberOfClosedIslands();

        int[][] grid = {{0,0,1,0,0}, {0,1,0,1,0}, {0,1,1,1,0}};

        System.out.println(lc.closedIsland(grid));
    }

//  Time Complexity - O(n x m)
    public int closedIsland(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        int count = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {

                if (grid[i][j] == 0) {
                    if (dfs(grid, i, j)) {
                        count++;
                    }
                }
            }
        }

        return count;
    }

    private boolean dfs(int[][] grid, int r, int c) {
        int m = grid.length;
        int n = grid[0].length;

        if (r < 0 || r >= m || c < 0 || c >= n) {
            return false;
        }

        if (grid[r][c] == 1) {
            return true;
        }

        grid[r][c] = 1;

        boolean up = dfs(grid, r - 1, c);
        boolean down = dfs(grid, r + 1, c);
        boolean left = dfs(grid, r, c - 1);
        boolean right = dfs(grid, r, c + 1);

        return up && down && left && right;
    }
}
