package leetcode.medium;

public class LC877_StoneGame {
    public static void main(String[] args) {
        int[] arr = {5,3,4,5};

        System.out.println(stoneGame(arr));
        System.out.println(stoneGame1(arr));
    }

//    Solution Using DP - Time Complexity - O(N^2)
    static Integer[][] dp;

    static boolean stoneGame1(int[] piles) {
        dp = new Integer[piles.length][piles.length];

        return solve(piles, 0, piles.length - 1) > 0;
    }

    static int solve(int[] piles, int left, int right) {

        if (left == right) {
            return piles[left];
        }

        if (dp[left][right] != null) {
            return dp[left][right];
        }

        int takeLeft = piles[left] - solve(piles, left + 1, right);

        int takeRight = piles[right] - solve(piles, left, right - 1);

        return dp[left][right] = Math.max(takeLeft, takeRight);
    }

//  Solution using Mathematical Observation - O(1)
    static boolean stoneGame(int[] piles){
        return true;
    }
}
