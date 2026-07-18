package leetcode.easy;

public class LC3658_GCDOfOddEvenSums {
    public static void main(String[] args) {
        int n = 4;

        System.out.println(gcdOfOddEvenSums(n));
    }

    static int  gcdOfOddEvenSums(int n){
        int sum_odd = 0;
        int sum_even = 0;

        for (int i = 1; i <= n * 2; i++) {
            if(i % 2 == 0){
                sum_even += i;
            }else {
                sum_odd += i;
            }
        }

        int gcd_sum = gcd(sum_odd, sum_even);
        return gcd_sum;
    }

    static int gcd(int a, int b){
        if(b == 0){
            return a;
        }
        return gcd(b, a % b);
    }
}
