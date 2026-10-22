package leetcode.medium;

public class LC3942_MinimumOperationsToSortAPermutation {
    public static void main(String[] args) {
        LC3942_MinimumOperationsToSortAPermutation lc = new LC3942_MinimumOperationsToSortAPermutation();

        int[] nums = {0,2,1};

        System.out.println(lc.minOperations(nums));
    }

//  Time Complexity - O(n)
    public int minOperations(int[] nums) {
        int n = nums.length;

        if (n == 1) return 0;

        int zero = 0;
        while (nums[zero] != 0) {
            zero++;
        }

        int ans = Integer.MAX_VALUE;

        boolean leftRotation = true;

        for (int i = 0; i < n; i++) {
            if (nums[(zero + i) % n] != i) {
                leftRotation = false;
                break;
            }
        }

        if (leftRotation) {
            ans = zero;

            int right = n - zero;

            if (right != n) {
                ans = Math.min(ans, right + 2);
            }
        }

        int k = (n - 1 - zero + n) % n;

        boolean reverseRotation = true;

        for (int i = 0; i < n; i++) {
            int index = n - 1 - ((k + i) % n);

            if (nums[index] != i) {
                reverseRotation = false;
                break;
            }
        }

        if (reverseRotation) {
            ans = Math.min(ans, 1 + Math.min(k, n - k));
        }

        return ans == Integer.MAX_VALUE ? -1 : ans;
    }
}
