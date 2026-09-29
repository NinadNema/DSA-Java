package leetcode.hard;

public class LC2267_CheckIfThereIsAValidParenthesesStringPath {
    public static void main(String[] args) {
        LC2267_CheckIfThereIsAValidParenthesesStringPath lc = new LC2267_CheckIfThereIsAValidParenthesesStringPath();

        char[][] grid = {
                {'(','(','('},
                {')','(',')'},
                {'(','(',')'},
                {'(','(',')'}
        };

        System.out.println(lc.hasValidPath(grid));
    }

//  Time Complexity - O(n * m * (m + n))
    public boolean hasValidPath(char[][] grid) {

        int m = grid.length;
        int n = grid[0].length;

        if (grid[0][0] == ')' || grid[m - 1][n - 1] == '(') {
            return false;
        }

        boolean[][][] dp = new boolean[m][n][m + n];

        dp[0][0][1] = true;

        for (int r = 0; r < m; r++) {

            for (int c = 0; c < n; c++) {

                for (int balance = 0; balance <= m + n - 1; balance++) {

                    if (!dp[r][c][balance]) {
                        continue;
                    }

                    if (r + 1 < m) {

                        int newBalance = balance;

                        if (grid[r + 1][c] == '(') {
                            newBalance++;
                        } else {
                            newBalance--;
                        }

                        if (newBalance >= 0) {
                            dp[r + 1][c][newBalance] = true;
                        }
                    }

                    if (c + 1 < n) {

                        int newBalance = balance;

                        if (grid[r][c + 1] == '(') {
                            newBalance++;
                        } else {
                            newBalance--;
                        }

                        if (newBalance >= 0) {
                            dp[r][c + 1][newBalance] = true;
                        }
                    }
                }
            }
        }

        return dp[m - 1][n - 1][0];
    }
}
