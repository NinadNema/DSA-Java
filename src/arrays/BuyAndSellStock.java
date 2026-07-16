package arrays;

public class BuyAndSellStock {
    public static void main(String[] args) {
        int[] num = {2,4,1};
        System.out.println(maxProfit(num));
    }

    static int maxProfit(int[] prices){
        int min = prices[0];
        int maxProfit = 0;
        for (int price : prices) {
            int profit = price - min;

            if (profit > maxProfit) {
                maxProfit = profit;
            }

            if (price < min) {
                min = price;
            }
        }
        return maxProfit;
    }
}
