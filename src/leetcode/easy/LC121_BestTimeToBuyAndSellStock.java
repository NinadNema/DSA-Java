package leetcode.easy;

public class LC121_BestTimeToBuyAndSellStock {
    public static void main(String[] args) {
        LC121_BestTimeToBuyAndSellStock lc = new LC121_BestTimeToBuyAndSellStock();

        int[] prices = {7,1,5,3,6,4};

        System.out.println(lc.maxProfit(prices));
    }

    public int maxProfit(int[] prices) {
        int profit = 0;
        int buy = Integer.MAX_VALUE;

        for(int num : prices){
            if(num < buy){
                buy = num;
            }else if(num - buy > profit){
                profit = num - buy;
            }
        }

        return profit;
    }
}
