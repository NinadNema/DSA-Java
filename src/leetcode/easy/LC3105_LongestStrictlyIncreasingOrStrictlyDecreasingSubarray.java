package leetcode.easy;

public class LC3105_LongestStrictlyIncreasingOrStrictlyDecreasingSubarray {
    public static void main(String[] args) {
        LC3105_LongestStrictlyIncreasingOrStrictlyDecreasingSubarray lc = new LC3105_LongestStrictlyIncreasingOrStrictlyDecreasingSubarray();

        int[] nums = new int[]{1, 4, 3, 3, 2};

        System.out.println(lc.longestMonotonicSubarray(nums));
    }

//  Time Complexity - O(n)
    public int longestMonotonicSubarray(int[] nums) {
        int inc = 1;
        int dec = 1;
        int ans = 1;

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[i - 1]) {
                inc++;
                dec = 1;
            }
            else if (nums[i] < nums[i - 1]) {
                dec++;
                inc = 1;
            }
            else {
                inc = 1;
                dec = 1;
            }

            ans = Math.max(ans, Math.max(inc, dec));
        }

        return ans;
    }
}
