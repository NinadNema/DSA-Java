package leetcode.medium;

import java.util.Arrays;

public class LC3946_MaximumNumberOfItemsFromSaleI {
    public static void main(String[] args) {
        LC3946_MaximumNumberOfItemsFromSaleI lc = new LC3946_MaximumNumberOfItemsFromSaleI();

        int[][] items = new int[][]{{6, 2}, {2, 6}, {3, 4}};
        int budget = 9;

        System.out.println(lc.maximumSaleItems(items, budget));
    }

//  Time Complexity - O(n ^ 2)
    public int maximumSaleItems(int[][] items, int budget) {
        int n = items.length;

        int[] benefit = new int[n];

        for (int i = 0; i < n; i++) {
            int count = 0;

            for (int j = 0; j < n; j++) {
                if (i != j && items[j][0] % items[i][0] == 0) {
                    count++;
                }
            }

            benefit[i] = count + 1;
        }

        int answer = 0;

        for (int minPrice = 1; minPrice <= 1500; minPrice++) {

            int[] dp = new int[budget + 1];
            Arrays.fill(dp, -1);
            dp[0] = 0;

            boolean exists = false;

            for (int i = 0; i < n; i++) {
                int price = items[i][1];

                if (price < minPrice) continue;

                if (price == minPrice) {
                    exists = true;
                }

                for (int cost = budget; cost >= price; cost--) {
                    if (dp[cost - price] != -1) {
                        dp[cost] = Math.max(
                                dp[cost],
                                dp[cost - price] + benefit[i]
                        );
                    }
                }
            }

            if (!exists) continue;

            for (int cost = minPrice; cost <= budget; cost++) {
                if (dp[cost] == -1) continue;

                int extra = (budget - cost) / minPrice;

                answer = Math.max(answer, dp[cost] + extra);
            }
        }

        return answer;
    }
}
