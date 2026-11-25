package leetcode.hard;

import java.util.*;

public class LC3934_SmallestUniqueSubarray {
    public static void main(String[] args) {
        LC3934_SmallestUniqueSubarray lc = new LC3934_SmallestUniqueSubarray();

        int[] nums = new int[]{3, 3, 3};

        System.out.println(lc.smallestUniqueSubarray(nums));
    }

//  Time Complexity - O(n log n)
    public int smallestUniqueSubarray(int[] nums) {
        int n = nums.length;

        int left = 1;
        int right = n;

        long base = 1000003L;
        long mod = 1_000_000_007L;

        long[] prefix = new long[n + 1];
        long[] power = new long[n + 1];

        power[0] = 1;

        for (int i = 0; i < n; i++) {
            prefix[i + 1] = (prefix[i] * base + nums[i]) % mod;
            power[i + 1] = (power[i] * base) % mod;
        }

        while (left < right) {
            int mid = left + (right - left) / 2;

            if (hasUnique(nums, mid, prefix, power, base, mod)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        return left;
    }

    private boolean hasUnique(int[] nums, int len,
                              long[] prefix, long[] power,
                              long base, long mod) {

        Map<Long, Integer> freq = new HashMap<>();

        for (int i = 0; i + len <= nums.length; i++) {
            long hash = (prefix[i + len]
                    - prefix[i] * power[len] % mod
                    + mod) % mod;

            freq.put(hash, freq.getOrDefault(hash, 0) + 1);
        }

        for (int count : freq.values()) {
            if (count == 1) {
                return true;
            }
        }

        return false;
    }
}
