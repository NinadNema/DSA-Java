package leetcode.easy;

public class LC3536_MaximumProductOfTwoDigits {
    public static void main(String[] args) {
        int n = 31;

        System.out.println(maxProduct(n));
    }

    static int maxProduct(int n){
        int max1 = 0;
        int max2  = 0;
        while(n > 0){
            int digit = n % 10;
            if(digit > max1){
                max2 = max1;
                max1 = digit;
            } else if(max2 < digit){
                max2 = digit;
            }
            n /= 10;
        }
        return max1 * max2;
    }
}
