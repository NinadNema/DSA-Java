package leetcode.easy;

public class LC3903_SmallestStableIndexI {
    public static void main(String[] args) {
        LC3903_SmallestStableIndexI lc = new LC3903_SmallestStableIndexI();

        int[] nums = {6,4,0,3,9};
        int k = 1;

        System.out.println(lc.firstStableIndex(nums, k));
    }

//  Time Complexity - O(n^2)
    public int firstStableIndex(int[] nums, int k) {
        for (int i = 0; i < nums.length; i++) {
            int max = Integer.MIN_VALUE;
            int min = Integer.MAX_VALUE;
            for (int j = 0; j <= i; j++) {
                if(max < nums[j]){
                    max = nums[j];
                }
            }
            for(int j = i; j < nums.length; j++){
                if(min > nums[j]){
                    min = nums[j];
                }
            }
            if(max - min <= k){
                return i;
            }
        }

        return -1;
    }
}
