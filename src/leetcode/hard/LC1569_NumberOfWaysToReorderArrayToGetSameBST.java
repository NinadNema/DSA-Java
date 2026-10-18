package leetcode.hard;

public class LC1569_NumberOfWaysToReorderArrayToGetSameBST {
    public static void main(String[] args) {
        LC1569_NumberOfWaysToReorderArrayToGetSameBST lc = new LC1569_NumberOfWaysToReorderArrayToGetSameBST();

        int[] nums = {2,1,3};

        System.out.println(lc.numOfWays(nums));
    }

    static final long MOD = 1_000_000_007L;
    long[][] comb;

//  Time Complexity - O(n^2)
    public int numOfWays(int[] nums) {
        int n = nums.length;

        comb = new long[n + 1][n + 1];

        for (int i = 0; i <= n; i++) {
            comb[i][0] = 1;
            comb[i][i] = 1;

            for (int j = 1; j < i; j++) {
                comb[i][j] = (comb[i - 1][j - 1] + comb[i - 1][j]) % MOD;
            }
        }

        long ans = solve(nums);

        return (int) ((ans - 1 + MOD) % MOD);
    }

    private long solve(int[] nums) {

        if (nums.length <= 2) {
            return 1;
        }

        int root = nums[0];

        int[] left = new int[nums.length];
        int[] right = new int[nums.length];

        int l = 0;
        int r = 0;

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < root) {
                left[l++] = nums[i];
            } else {
                right[r++] = nums[i];
            }
        }

        int[] leftTree = new int[l];
        int[] rightTree = new int[r];

        System.arraycopy(left, 0, leftTree, 0, l);
        System.arraycopy(right, 0, rightTree, 0, r);

        long leftWays = solve(leftTree);
        long rightWays = solve(rightTree);

        long waysToInterleave = comb[l + r][l];

        return (((waysToInterleave * leftWays) % MOD) * rightWays) % MOD;
    }
}
