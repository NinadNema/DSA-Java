package leetcode.easy;

import java.util.List;

public class LC3364_MinimumPositiveSumSubarray {
    public static void main(String[] args) {
        LC3364_MinimumPositiveSumSubarray lc = new LC3364_MinimumPositiveSumSubarray();

        java.util.List<Integer> nums = new java.util.ArrayList<>(java.util.Arrays.asList(3, -2, 1, 4));
        int l = 2;
        int r = 3;

        System.out.println(lc.minimumSumSubarray(nums, l, r));
    }

//  Time Complexity - O(n ^ 2)
    public int minimumSumSubarray(List<Integer> nums, int l, int r) {
        int n = nums.size();

        int[] prefix = new int[n + 1];

        for (int i = 0; i < n; i++) {
            prefix[i + 1] = prefix[i] + nums.get(i);
        }

        int ans = Integer.MAX_VALUE;

        for (int i = 0; i < n; i++) {
            for (int len = l; len <= r; len++) {

                if (i + len > n) break;

                int sum = prefix[i + len] - prefix[i];

                if (sum > 0) {
                    ans = Math.min(ans, sum);
                }
            }
        }

        return ans == Integer.MAX_VALUE ? -1 : ans;
    }
}
