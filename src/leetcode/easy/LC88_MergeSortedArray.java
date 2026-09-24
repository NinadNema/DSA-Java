package leetcode.easy;

import java.util.Arrays;

public class LC88_MergeSortedArray {
    public static void main(String[] args) {
        LC88_MergeSortedArray lc = new LC88_MergeSortedArray();

        int[] nums1 = {4,0,0,0,0,0};
        int m = 1;
        int[] nums2 = {1,2,3,5,6};
        int n = 5;

        lc.merge(nums1, m, nums2, n);
        System.out.println(Arrays.toString(nums1));
    }

//  Time Complexity - O(m + n)
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int l = m - 1;
        int r = n - 1;
        int k = m + n - 1;

        while(l >=0 && r >= 0){
            if(nums1[l] > nums2[r]){
                nums1[k] = nums1[l];
                l--;
            }else{
                nums1[k] = nums2[r];
                r--;
            }
            k--;
        }

        while(r >= 0){
            nums1[k--] = nums2[r--];
        }
    }
}
