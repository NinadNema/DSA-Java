package arrays;

import java.util.Arrays;

public class RemoveDuplicates {
    public static void main(String[] args) {
        int[] arr = {};
        System.out.println(removeDuplicates(arr));
        System.out.println(Arrays.toString(arr));
    }

    static int removeDuplicates(int[] nums){
        int writeIndex = 1;
        if (nums.length == 0){
            return 0;
        }
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[i-1]){
                nums[writeIndex] = nums[i];
                writeIndex += 1;
            }
        }
        return writeIndex;
    }
}
