package leetcode.medium;

public class LC3702_LongestSubsequenceWithNonZeroBitwiseXOR {
    public static void main(String[] args) {
        LC3702_LongestSubsequenceWithNonZeroBitwiseXOR lc = new LC3702_LongestSubsequenceWithNonZeroBitwiseXOR();

        int[] arr = {1,2,3};

        System.out.println(lc.longestSubsequence(arr));
    }

//  Time Complexity - O(n)
    public int longestSubsequence(int[] nums) {
        int xor = nums[0];
        for (int i = 1; i < nums.length; i++) {
            xor ^= nums[i];
        }
        if(xor != 0){
            return nums.length;
        }

        int count = 0;
        if(xor == 0){
            for (int num : nums) {
                if(num == 0){
                    count++;
                }
            }
        }

        if(count == nums.length) {
            return 0;
        }
        else{
            return nums.length - 1;
        }
    }
}
