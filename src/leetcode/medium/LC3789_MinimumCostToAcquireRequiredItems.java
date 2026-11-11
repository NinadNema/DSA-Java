package leetcode.medium;

public class LC3789_MinimumCostToAcquireRequiredItems {
    public static void main(String[] args) {
        LC3789_MinimumCostToAcquireRequiredItems lc = new LC3789_MinimumCostToAcquireRequiredItems();

        int cost1 = 3;
        int cost2 = 2;
        int costBoth = 1;
        int need1 = 3;
        int need2 = 2;

        System.out.println(lc.minimumCost(cost1, cost2, costBoth, need1, need2));
    }

//  Time Complexity - O(1)
    public long minimumCost(int cost1, int cost2, int costBoth, int need1, int need2) {
        long option1 = (long) cost1 * need1 + (long) cost2 * need2;

        long option2 = (long) Math.max(need1, need2) * costBoth;

        int common = Math.min(need1, need2);

        long option3 = (long) common * costBoth + (long) (need1 - common) * cost1 + (long) (need2 - common) * cost2;

        return Math.min(option1, Math.min(option2, option3));
    }
}
