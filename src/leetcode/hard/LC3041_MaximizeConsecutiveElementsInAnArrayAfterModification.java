package leetcode.hard;

import java.util.*;

public class LC3041_MaximizeConsecutiveElementsInAnArrayAfterModification {
    public static void main(String[] args) {
        LC3041_MaximizeConsecutiveElementsInAnArrayAfterModification lc = new LC3041_MaximizeConsecutiveElementsInAnArrayAfterModification();

        int[] nums = new int[]{2, 1, 5, 1, 1};

        System.out.println(lc.maxSelectedElements(nums));
    }

//  Time Complexity - O(n log n)
    public int maxSelectedElements(int[] nums) {
        Arrays.sort(nums);

        HashMap<Integer, Integer> dp = new HashMap<>();
        int ans = 0;

        for (int x : nums) {
            int oldX = dp.getOrDefault(x, 0);

            int keep = dp.getOrDefault(x - 1, 0) + 1;

            int increase = oldX + 1;

            dp.put(x, Math.max(dp.getOrDefault(x, 0),
                    Math.max(keep, 1)));

            dp.put(x + 1, Math.max(dp.getOrDefault(x + 1, 0),
                    Math.max(increase, 1)));

            ans = Math.max(ans, dp.get(x));
            ans = Math.max(ans, dp.get(x + 1));
        }

        return ans;
    }
}
