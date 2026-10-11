package leetcode.easy;

public class LC2778_SumOfSquaresOfSpecialElements {
    public static void main(String[] args) {
        LC2778_SumOfSquaresOfSpecialElements lc = new LC2778_SumOfSquaresOfSpecialElements();

        int[] nums = {1,2,3,4};

        System.out.println(lc.sumOfSquares(nums));
    }

//  Time Complexity - O(n)
    public int sumOfSquares(int[] nums) {
        int n = nums.length;
        int sum = 0;

        for (int i = 0; i < nums.length; i++) {
            if(n % (i + 1) == 0){
                sum += nums[i] * nums[i];
            }
        }

        return sum;
    }
}
