package leetcode.medium;

public class LC2333_MinimumSumOfSquaredDifference {
    public static void main(String[] args) {
        LC2333_MinimumSumOfSquaredDifference lc = new LC2333_MinimumSumOfSquaredDifference();

        int[] nums1 = {};
        int[] nums2 = {};
        int k1 = 0;
        int k2 = 0;

        System.out.println(lc.minSumSquareDiff(nums1, nums2, k1, k2));

    }

//  Time Complexity - O(n log D)
    public long minSumSquareDiff(int[] nums1, int[] nums2, int k1, int k2) {
        long operations = (long) k1 + k2;
        int n = nums1.length;
        int[] diff = new int[n];

        int maxDiff = 0;
        long sum = 0;

        for (int i = 0; i < n; i++) {
            diff[i] = Math.abs(nums1[i] - nums2[i]);
            maxDiff = Math.max(maxDiff, diff[i]);
            sum += diff[i];
        }

        if (operations >= sum) {
            return 0;
        }

        int left = 0;
        int right = maxDiff;

        while (left < right) {
            int mid = left + (right - left) / 2;
            long needed = 0;

            for (int d : diff) {
                if (d > mid) {
                    needed += d - mid;
                }
            }

            if (needed <= operations) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        int limit = left;
        long answer = 0;
        long remaining = operations;

        for (int d : diff) {
            if (d > limit) {
                remaining -= d - limit;
                d = limit;
            }
            answer += (long) d * d;
        }

        if (limit > 0) {
            answer -= remaining * (2L * limit - 1);
        }

        return answer;
    }
}
