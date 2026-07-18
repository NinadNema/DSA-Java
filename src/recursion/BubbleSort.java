package recursion;

import java.util.Arrays;

public class BubbleSort {
    public static void main(String[] args) {
        int[] asc = {2,1,4,5,3};
        int[] desc = {2,1,4,5,3};

        System.out.println(Arrays.toString(bubbleSortAsc(asc, asc.length - 1, 0)));
        System.out.println(Arrays.toString(bubbleSortDesc(desc, desc.length - 1, 0)));
    }
//    ascending order
    static int[] bubbleSortAsc(int[] nums, int l, int r){
        if(l == 0){
            return nums;
        }
        if(r < l){
            if(nums[r] > nums[r + 1]){
                int temp = nums[r + 1];
                nums[r + 1] = nums[r];
                nums[r] = temp;
            }
            bubbleSortAsc(nums, l, r + 1);
        }else {
            bubbleSortAsc(nums, l - 1, 0);
        }
        return nums;
    }

//    descending order
    static int[] bubbleSortDesc(int[] nums, int l, int r){
        if(l == 0){
            return nums;
        }
        if(r < l){
            if(nums[r] < nums[r + 1]){
                int temp = nums[r + 1];
                nums[r + 1] = nums[r];
                nums[r] = temp;
            }
            bubbleSortDesc(nums, l, r + 1);
        }else {
            bubbleSortDesc(nums, l - 1, 0);
        }
        return nums;
    }
}
