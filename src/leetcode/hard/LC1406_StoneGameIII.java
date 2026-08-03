package leetcode.hard;

public class LC1406_StoneGameIII {
    public static void main(String[] args) {
        int[] arr = {1,2,3,-9};

        System.out.println(stoneGameIII(arr));
    }

//    Time Complexity - O(N)
    static Integer[] dp;

    static String stoneGameIII(int[] stoneValue){
        dp = new Integer[stoneValue.length];

        int diff = solve(stoneValue, 0);

        if (diff > 0) {
            return "Alice";
        } else if (diff < 0) {
            return "Bob";
        }

        return "Tie";
    }

    static int solve(int[] stoneValue, int index) {

        if (index >= stoneValue.length) {
            return 0;
        }

        if (dp[index] != null) {
            return dp[index];
        }

        int maxDiff = Integer.MIN_VALUE;
        int sum = 0;

        for (int i = index; i < Math.min(index + 3, stoneValue.length); i++) {

            sum += stoneValue[i];

            maxDiff = Math.max(maxDiff, sum - solve(stoneValue, i + 1));
        }

        return dp[index] = maxDiff;
    }
}
