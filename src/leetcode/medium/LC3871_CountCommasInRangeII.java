package leetcode.medium;

public class LC3871_CountCommasInRangeII {
    public static void main(String[] args) {
        LC3871_CountCommasInRangeII lc = new LC3871_CountCommasInRangeII();

        long n = 1004590;

        System.out.println(lc.countCommas(n));
    }

//  Time Complexity - O(log n)
    public long countCommas(long n) {
        long ans = 0;

        long start = 1000;
        long commas = 1;

        while (start <= n) {
            long end = Math.min(n, start * 1000 - 1);

            long count = end - start + 1;

            ans += count * commas;

            start *= 1000;
            commas++;
        }

        return ans;
    }
}
