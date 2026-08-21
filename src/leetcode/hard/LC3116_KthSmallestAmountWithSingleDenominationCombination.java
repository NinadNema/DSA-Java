package leetcode.hard;

import java.util.Arrays;

public class LC3116_KthSmallestAmountWithSingleDenominationCombination {
    public static void main(String[] args) {
        LC3116_KthSmallestAmountWithSingleDenominationCombination lc = new LC3116_KthSmallestAmountWithSingleDenominationCombination();

        int[] arr = {5,2};
        int k = 7;

        System.out.println(lc.findKthSmallest(arr, k));
    }

    public long findKthSmallest(int[] coins, int k){
        long low = 1;
        long high = (long) Arrays.stream(coins).min().getAsInt() * k;

        while(low < high){
            long mid = low + (high - low) / 2;

            if(count(mid, coins) >= k){
                high = mid;
            }else{
                low = mid + 1;
            }
        }

        return low;
    }

    static long count(long x, int[] coins){
        int n = coins.length;
        long result = 0;

        for (int mask = 1; mask < (1 << n); mask++) {

            long lcm = 1;
            int bits = 0;
            boolean overflow = false;

            for (int i = 0; i < n; i++) {

                if ((mask & (1 << i)) != 0) {

                    bits++;

                    long g = gcd(lcm, coins[i]);

                    long next = lcm / g * coins[i];

                    if (next > x) {
                        overflow = true;
                        break;
                    }

                    lcm = next;
                }
            }

            if (overflow) {
                continue;
            }

            long ways = x / lcm;

            if (bits % 2 == 1) {
                result += ways;
            } else {
                result -= ways;
            }
        }

        return result;
    }

    static long gcd(long a, long b){
        while(b != 0){
            long temp = a % b;
            a = b;
            b = temp;
        }

        return a;
    }
}
