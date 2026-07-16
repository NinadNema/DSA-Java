package arrays;

import java.util.Arrays;

public class MergeSortedArray {
    public static void main(String[] args) {
        int[] arr = {1,2,3,0,0,0};
        int[] arr2 = {2,5,6};

        merge(arr,3, arr2,3);
    }

    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int j = 0;
        for (int i = m; i < nums1.length; i++) {
            nums1[i] = nums1[i] + nums2[j];
            j++;
        }

        for (int i = 0; i < nums1.length; i++) {
            for (int k = 1; k < nums1.length-i; k++) {
                if(nums1[k] < nums1[k-1]){
                    int temp = nums1[k];
                    nums1[k] = nums1[k-1];
                    nums1[k-1] = temp;
                }
            }
        }
        System.out.println(Arrays.toString(nums1));
    }
}
