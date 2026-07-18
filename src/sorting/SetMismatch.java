package sorting;

import java.util.Arrays;

public class SetMismatch {
    public static void main(String[] args) {
        int[] arr = {2,4,4,3,6,5};
        System.out.println(Arrays.toString(findErrorNums(arr)));
//        System.out.println(findErrorNums(arr));
    }

    public static int[] findErrorNums(int[] nums) {
        int  i = 0;
        while(i < nums.length){
            int cor = nums[i] - 1;
            if(nums[i] != nums[cor]){
                int temp = nums[i];
                nums[i] = nums[cor];
                nums[cor] = temp;
            }
            else{
                i++;
            }
        }

        for (int j = 0; j < nums.length; j++) {
            if(nums[j] != j+1){
                return new int[] {nums[j],j+1};
            }
        }
        return new int[] {-1,-1};
    }
}
