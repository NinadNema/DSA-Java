package leetcode.medium;

import java.util.Arrays;

public class LC912_SortAnArray {
    public static void main(String[] args) {
        int[] arr = {5,1,1,2,0,0};

        System.out.println(Arrays.toString(sortArray(arr)));
    }

    static int[] sortArray(int[] nums){
        if(nums.length == 1){
            return nums;
        }

        int mid = nums.length / 2;

        int[] left = sortArray(Arrays.copyOfRange(nums, 0, mid));
        int[] right = sortArray(Arrays.copyOfRange(nums, mid, nums.length));

        return merge(left, right);
    }

    static int[] merge(int[] f, int[] s){
        int[] mix = new int[f.length + s.length];

        int l = 0;
        int r = 0;
        int k = 0;

        while(l < f.length && r < s.length){
            if(f[l] < s[r]){
                mix[k] = f[l];
                l++;
            }else{
                mix[k] = s[r];
                r++;
            }
            k++;
        }

        while(l < f.length){
            mix[k] = f[l];
            k++;
            l++;
        }

        while(r < s.length){
            mix[k] = s[r];
            k++;
            r++;
        }

        return mix;
    }
}
