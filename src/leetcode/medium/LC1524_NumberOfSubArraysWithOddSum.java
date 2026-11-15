package leetcode.medium;

public class LC1524_NumberOfSubArraysWithOddSum {
    public static void main(String[] args) {
        LC1524_NumberOfSubArraysWithOddSum lc = new LC1524_NumberOfSubArraysWithOddSum();

        int[] arr = new int[]{1, 3, 5};

        System.out.println(lc.numOfSubarrays(arr));
    }

//  Time Complexity - O(n)
    public int numOfSubarrays(int[] arr) {
        final int MOD = 1_000_000_007;

        long even = 1;
        long odd = 0;

        long ans = 0;
        int sum = 0;

        for (int num : arr) {
            sum += num;

            if (sum % 2 == 0) {
                ans += odd;
                even++;
            } else {
                ans += even;
                odd++;
            }

            ans %= MOD;
        }

        return (int) ans;
    }
}
