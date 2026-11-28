package leetcode.medium;

import java.util.*;

public class LC3947_MaximumNumberOfItemsFromSaleII {
    public static void main(String[] args) {
        LC3947_MaximumNumberOfItemsFromSaleII lc = new LC3947_MaximumNumberOfItemsFromSaleII();

        int[][] items = new int[][]{{1, 6}, {2, 4}, {3, 5}};
        int budget = 19;

        System.out.println(lc.maximumSaleItems(items, budget));
    }

//  Time Complexity - O(n log n)
    public int maximumSaleItems(int[][] items, int budget) {
        int n = items.length;
        int[] count = new int[n + 1];
        for (int[] it : items) {
            count[it[0]]++;
        }
        int[] multiples = new int[n + 1];
        for (int f = 1; f <= n; f++) {
            int s = 0;
            for (int m = f; m <= n; m += f) {
                s += count[m];
            }
            multiples[f] = s;
        }
        long[][] arr = new long[n][2];
        long pmin = Long.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            arr[i][0] = items[i][1];
            arr[i][1] = multiples[items[i][0]] - 1;
            pmin = Math.min(pmin, arr[i][0]);
        }
        Arrays.sort(arr, (a, b) -> Long.compare(a[0], b[0]));
        long remaining = budget;
        long total = 0;
        for (int i = 0; i < n; i++) {
            long p = arr[i][0];
            long c = arr[i][1];
            if (p >= 2 * pmin) {
                break;
            }
            if (c == 0) {
                continue;
            }
            long k = Math.min(c, remaining / p);
            total += 2 * k;
            remaining -= k * p;
            if (k < c) {
                break;
            }
        }
        total += remaining / pmin;
        return (int) total;
    }
}
