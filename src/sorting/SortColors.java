package sorting;

import java.util.Arrays;

public class SortColors {
    public static void main(String[] args) {
        int[] arr = {0,1,0,3,12};

        sortColors(arr);
    }

    public static void sortColors(int[] nums) {
        boolean swap;
        for (int i = 0; i < nums.length; i++) {
            swap = false;
            for (int j = 1; j < nums.length-i; j++) {
                if(nums[j] < nums[j-1]){
                    int temp = nums[j];
                    nums[j] = nums[j-1];
                    nums[j-1] = temp;
                    swap =true;
                }
            }
            if(!swap){
                break;
            }
        }
        System.out.println(Arrays.toString(nums));
    }
}
