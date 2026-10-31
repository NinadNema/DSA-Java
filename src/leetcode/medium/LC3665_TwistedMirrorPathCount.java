package leetcode.medium;

public class LC3665_TwistedMirrorPathCount {
    public static void main(String[] args) {
        LC3665_TwistedMirrorPathCount lc = new LC3665_TwistedMirrorPathCount();

        int[][] grid = {{0,1,1}, {1,1,0}};

        System.out.println(lc.uniquePaths(grid));
    }

//  Time Complexity - O(m x n)
    public int uniquePaths(int[][] grid) {
        final int MOD = 1_000_000_007;
        int m = grid.length, n = grid[0].length;
        int[][] R = new int[m][n];
        int[][] D = new int[m][n];
        R[0][0] = 1;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 && j == 0) continue;
                long r = 0, d = 0;
                if (j > 0) {
                    r = (grid[i][j - 1] == 0)
                            ? (R[i][j - 1] + D[i][j - 1]) % MOD
                            : D[i][j - 1];
                }
                if (i > 0) {
                    d = (grid[i - 1][j] == 0)
                            ? (R[i - 1][j] + D[i - 1][j]) % MOD
                            : R[i - 1][j];
                }
                R[i][j] = (int) r;
                D[i][j] = (int) d;
            }
        }
        return (int) (((long) R[m - 1][n - 1] + D[m - 1][n - 1]) % MOD);
    }
}
