package recursion;

import java.util.Arrays;

public class SelectionSort {
    public static void main(String[] args) {
        int[] arr = {2,1,4,5,3};

        selctionSort(arr, 0, arr.length - 1, 0);

        System.out.println(Arrays.toString(arr));
    }

    static void selctionSort(int[] nums, int r, int c, int max){
        if(c == 0){
            return;
        }

        if(r <= c){
            if(nums[r] > nums[max]){
                max = r;
            }
            selctionSort(nums, r + 1, c, max);
        }
        else{
            int temp = nums[max];
            nums[max] = nums[c];
            nums[c] = temp;

            selctionSort(nums, 0, c - 1, 0);
        }
    }
}
