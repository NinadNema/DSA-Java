package leetcode.medium;

public class LC122_BestTimeToBuyAndSellStockII {
    public static void main(String[] args) {
        LC122_BestTimeToBuyAndSellStockII lc = new LC122_BestTimeToBuyAndSellStockII();

        int[] prices = {7,6,4,3,1};

        System.out.println(lc.maxProfit(prices));
    }

//  Time Complexity - O(n)
    public int maxProfit(int[] prices) {
        int buy = Integer.MAX_VALUE;
        int profit = 0;
        int maxProfit = 0;

        for(int sell : prices){
            if(sell < buy){
                buy = sell;
            }else if ( sell - buy > profit){
                profit += sell - buy;
                buy = sell;
            }
            maxProfit += profit;
            profit = 0;
        }

        return maxProfit;
    }
}
