package leetcode.medium;

public class LC486_PredictTheWinner {
    public static void main(String[] args) {
        int[] arr = {1,5,233,7};

        System.out.println(predictTheWinner(arr));
    }

//    Time Complexity - O(2^n)
    static boolean predictTheWinner(int[] nums){
        return solve(nums, 0, nums.length - 1) >= 0;
    }

    static int solve(int[] nums, int left, int right){
        if(left == right){
            return nums[left];
        }

        int takeleft = nums[left] - solve(nums, left + 1, right);
        int takeright = nums[right] - solve(nums, left, right - 1);

        return Math.max(takeleft, takeright);
    }
}
