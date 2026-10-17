package leetcode.medium;

import java.util.*;

public class LC3551_MinimumSwapsToSortByDigitSum {
    public static void main(String[] args) {
        LC3551_MinimumSwapsToSortByDigitSum lc = new LC3551_MinimumSwapsToSortByDigitSum();

        int[] nums = {37, 100};

        System.out.println(lc.minSwaps(nums));
    }

//  Time Complexity - O(n log n)
    public int minSwaps(int[] nums) {
        int n = nums.length;

        Integer[] sorted = new Integer[n];

        for (int i = 0; i < n; i++) {
            sorted[i] = nums[i];
        }

        Arrays.sort(sorted, (a, b) -> {
            int sumA = digitSum(a);
            int sumB = digitSum(b);

            if (sumA != sumB) {
                return Integer.compare(sumA, sumB);
            }

            return Integer.compare(a, b);
        });

        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < n; i++) {
            map.put(nums[i], i);
        }

        int swaps = 0;

        for (int i = 0; i < n; i++) {

            if (nums[i] == sorted[i]) {
                continue;
            }

            int j = map.get(sorted[i]);

            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;

            map.put(nums[j], j);
            map.put(nums[i], i);

            swaps++;
        }

        return swaps;
    }

    private int digitSum(int num) {
        int sum = 0;

        while (num > 0) {
            sum += num % 10;
            num /= 10;
        }

        return sum;
    }
}
