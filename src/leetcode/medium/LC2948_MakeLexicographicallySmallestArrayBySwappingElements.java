package leetcode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class LC2948_MakeLexicographicallySmallestArrayBySwappingElements {
    public static void main(String[] args) {
        LC2948_MakeLexicographicallySmallestArrayBySwappingElements lc = new LC2948_MakeLexicographicallySmallestArrayBySwappingElements();
        int[] arr = {1,5,3,9,8};
        int limit = 2;

        System.out.println(Arrays.toString(lc.lexicographicallySmallestArray(arr, limit)));
    }

//  Time Complexity - O(n log n)
    public int[] lexicographicallySmallestArray(int[] nums, int limit) {
        int n = nums.length;

        int[][] arr = new int[n][2];

        for (int i = 0; i < n; i++) {
            arr[i][0] = nums[i];
            arr[i][1] = i;
        }

        Arrays.sort(arr, (a, b) -> Integer.compare(a[0], b[0]));

        int start = 0;

        while (start < n) {

            int end = start;

            while (end + 1 < n &&
                    (long) arr[end + 1][0] - arr[end][0] <= limit) {
                end++;
            }

            ArrayList<Integer> values = new ArrayList<>();
            ArrayList<Integer> indices = new ArrayList<>();

            for (int i = start; i <= end; i++) {
                values.add(arr[i][0]);
                indices.add(arr[i][1]);
            }

            Collections.sort(indices);

            for (int i = 0; i < values.size(); i++) {
                nums[indices.get(i)] = values.get(i);
            }

            start = end + 1;
        }

        return nums;
    }
}
