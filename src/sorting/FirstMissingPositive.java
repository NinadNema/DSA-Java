package sorting;

import java.util.Arrays;

public class FirstMissingPositive {
    public static void main(String[] args) {
        int[] arr = {1};
//        System.out.println(Arrays.toString(firstMissingPositive(arr)));
        System.out.println(firstMissingPositive(arr));
    }

    public static int firstMissingPositive(int[] nums){
        int i = 0;
        while(i< nums.length){
            if(nums[i] <= 0 || nums[i] > nums.length){
                i++;
            }
            else {
                int cor = nums[i] - 1;
                if (nums[i] != nums[cor]) {
                    int temp = nums[i];
                    nums[i] = nums[cor];
                    nums[cor] = temp;
                } else {
                    i++;
                }
            }
        }

        for (int j = 0; j < nums.length; j++) {
            if(nums[j] != j+1){
                return j+1;
            }
        }
        return nums.length+1;
    }
}
