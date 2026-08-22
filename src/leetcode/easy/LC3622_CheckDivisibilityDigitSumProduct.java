package leetcode.easy;

public class LC3622_CheckDivisibilityDigitSumProduct {
    public static void main(String[] args) {
        LC3622_CheckDivisibilityDigitSumProduct lc = new LC3622_CheckDivisibilityDigitSumProduct();

        int n = 99;

        System.out.println(lc.checkDivisibility(n));
    }

//  Time Complexity - O(log n)
    public boolean checkDivisibility(int n) {
        int sum = 0;
        int product = 1;
        int original = n;

        while(n > 0){
            int digit = n % 10;
            sum += digit;
            product *= digit;
            n /= 10;
        }

        return original % (sum + product) == 0;
    }
}
