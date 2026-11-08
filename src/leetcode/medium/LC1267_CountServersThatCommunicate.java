package leetcode.medium;

public class LC1267_CountServersThatCommunicate {
    public static void main(String[] args) {
        LC1267_CountServersThatCommunicate lc = new LC1267_CountServersThatCommunicate();

        int[][] grid = {{1,0}, {1, 1}};

        System.out.println(lc.countServers(grid));
    }

//  Time Complexity - O(m x n)
    public int countServers(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        int[] row = new int[m];
        int[] col = new int[n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    row[i]++;
                    col[j]++;
                }
            }
        }

        int ans = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1 &&
                        (row[i] > 1 || col[j] > 1)) {

                    ans++;
                }
            }
        }

        return ans;
    }
}
