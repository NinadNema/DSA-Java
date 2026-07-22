package recursion;

import java.util.Arrays;

public class MergeSort {
    public static void main(String[] args) {
        int[] arr = {8,3,4,12,5,6};

//        arr = sort(arr);
//        System.out.println(Arrays.toString(arr));

        mergeSort(arr, 0, arr.length);
        System.out.println(Arrays.toString(arr));
    }

//    Merge Sort using new array
    static int[] sort(int[] nums){
        if(nums.length == 1){
            return nums;
        }

        int mid = nums.length / 2;

        int[] left = sort(Arrays.copyOfRange(nums, 0, mid));
        int[] right = sort(Arrays.copyOfRange(nums, mid, nums.length));

        return merge(left, right);
    }

    static int[] merge(int[] first, int[] second){
        int[] result = new int[first.length + second.length];

        int l = 0;
        int r = 0;
        int i = 0;

        while(l < first.length && r < second.length){
            if(first[l] < second[r]){
                result[i] = first[l];
                l++;
            }else{
                result[i] = second[r];
                r++;
            }
            i++;
        }
        while(l < first.length){
            result[i] = first[l];
            i++;
            l++;
        }

        while(r < second.length){
            result[i] = second[r];
            r++;
            i++;
        }

        return result;
    }

//    Merge sort using in Place
    static void mergeSort(int[] nums, int s, int e){
        if(e -s == 1){
            return;
        }

        int mid = (s + e) / 2;

        mergeSort(nums, s, mid);
        mergeSort(nums, mid, e);

        mergeInPlace(nums, s, mid, e);
    }

    static void mergeInPlace(int[] nums, int s, int m , int e) {
        int[] result = new int[e - s];

        int l = s;
        int r = m;
        int i = 0;

        while (l < m && r < e) {
            if (nums[l] < nums[r]) {
                result[i] = nums[l];
                l++;
            } else {
                result[i] = nums[r];
                r++;
            }
            i++;
        }
        while (l < m) {
            result[i] = nums[l];
            i++;
            l++;
        }

        while (r < e) {
            result[i] = nums[r];
            r++;
            i++;
        }

        for (int j = 0; j < result.length; j++) {
            nums[s + j] = result[j];
        }
    }
}
