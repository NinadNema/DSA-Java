package leetcode.easy;

public class LC3550_SmallestIndexWithDigitSumEqualToIndex {
    public static void main(String[] args) {
        LC3550_SmallestIndexWithDigitSumEqualToIndex lc = new LC3550_SmallestIndexWithDigitSumEqualToIndex();

        int[] nums = {};

        System.out.println(lc.smallestIndex(nums));
    }

//  Time Complexity - O(n)
    public int smallestIndex(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            int sum = 0;
            while(nums[i] > 0){
                sum += nums[i] % 10;
                nums[i] /= 10;
            }

            if(sum == i){
                return i;
            }
        }

        return -1;
    }
}
