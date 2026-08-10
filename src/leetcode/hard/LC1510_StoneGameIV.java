package leetcode.hard;

public class LC1510_StoneGameIV {
    public static void main(String[] args) {
        LC1510_StoneGameIV lc = new LC1510_StoneGameIV();
        int n = 4;

        System.out.println(lc.winnerSquareGame(n));
    }

//  Time Complexity - O(n√n)
    public boolean winnerSquareGame(int n){
        Boolean[] dp = new Boolean[n+1];
        return solve(n, dp);
    }

    private boolean solve(int n, Boolean[] dp) {
        if(n == 0){
            return false;
        }

        if(dp[n] != null){
            return dp[n];
        }

        for(int i = 1; i * i <= n; i++){
            int square = i * i;

            if(!solve(n - square, dp)){
                dp[n] = true;
                return true;
            }
        }

        dp[n] = false;
        return false;
    }
}
