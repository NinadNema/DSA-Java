package leetcode.hard;

import java.util.Arrays;

class LC3312_SortedGCDPairQueries {
    public static void main(String[] args) {
        int[] arr = {3, 6, 9, 12};
        long[] queries = {0, 3, 5};
        System.out.println(Arrays.toString(gcdValues(arr, queries)));
    }

    static int[] gcdValues(int[] nums, long[] queries) {
        int max = 0;
        for (int x : nums) {
            max = Math.max(max, x);
        }

        // Frequency of each number
        int[] freq = new int[max + 1];
        for (int x : nums) {
            freq[x]++;
        }

        // cnt[g] = numbers divisible by g
        long[] cnt = new long[max + 1];
        for (int g = 1; g <= max; g++) {
            for (int multiple = g; multiple <= max; multiple += g) {
                cnt[g] += freq[multiple];
            }
        }

        // exact[g] = pairs having gcd exactly g
        long[] exact = new long[max + 1];

        for (int g = max; g >= 1; g--) {
            exact[g] = cnt[g] * (cnt[g] - 1) / 2;

            for (int multiple = g * 2; multiple <= max; multiple += g) {
                exact[g] -= exact[multiple];
            }
        }

        // Prefix sums
        long[] prefix = new long[max + 1];
        for (int g = 1; g <= max; g++) {
            prefix[g] = prefix[g - 1] + exact[g];
        }

        int[] ans = new int[queries.length];

        for (int i = 0; i < queries.length; i++) {
            long target = queries[i] + 1; // 0-based index

            int left = 1;
            int right = max;

            while (left < right) {
                int mid = left + (right - left) / 2;

                if (prefix[mid] >= target) {
                    right = mid;
                } else {
                    left = mid + 1;
                }
            }

            ans[i] = left;
        }

        return ans;
    }
}