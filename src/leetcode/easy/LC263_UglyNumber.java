package leetcode.easy;

public class LC263_UglyNumber {
    public static void main(String[] args) {
        int n = 0;
        System.out.println(isUgly(n));
    }
//  Time Complexity - O(log n)
    static boolean isUgly(int n){
        if (n <= 0) return false;

        int[] factors = {2, 3, 5};

        for (int factor : factors) {
            while (n % factor == 0) {
                n /= factor;
            }
        }

        return n == 1;
    }
}
