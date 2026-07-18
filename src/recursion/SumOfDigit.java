package recursion;

public class SumOfDigit {
    public static void main(String[] args) {
        int n = 1342;
        System.out.println(sum_digit(n));
        System.out.println(sum_digit_iterative(n));
    }

    static int sum_digit_iterative(int n){
        int sum = 0;
        while ( n > 0){
            int digit = n % 10;
            sum += digit;
            n /= 10;
        }
        return sum;
    }

    static int sum_digit(int n){
        if(n <= 0){
            return 0;
        }
        int digit = n % 10;
        return digit + sum_digit(n / 10);
    }
}
