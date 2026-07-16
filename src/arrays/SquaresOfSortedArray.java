package arrays;

import java.util.Arrays;

public class SquaresOfSortedArray {
    public static void main(String[] args) {
        int[] arr = {-4,-4,-3};

        System.out.println(Arrays.toString(sortedSquares(arr)));
    }

    public static int[] sortedSquares(int[] nums){
        for (int i = 0; i < nums.length; i++) {
            nums[i] = nums[i]*nums[i];
        }

        for (int i = 0; i <= nums.length-2; i++) {
            for (int j = i+1; j > 0; j--) {
                if(nums[j] < nums[j-1]){
                    int temp = nums[j];
                    nums[j] = nums[j-1];
                    nums[j-1] = temp;
                }
                else{
                    break;
                }
            }
        }
        return nums;
    }
}
