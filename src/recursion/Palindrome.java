package recursion;

public class Palindrome {
    public static void main(String[] args) {
        int n = 121;
        System.out.println(isPalindrome(n));
        System.out.println(isPalindromeRecursion(n, n));
    }

    static boolean isPalindrome(int n){
        int rev = 0;
        int ori = n;

        while(n > 0){
            int digit = n % 10;
            rev = (rev * 10) + digit;
            n /= 10;
        }

        return rev == ori;
    }

    static int sum = 0;
    static boolean isPalindromeRecursion(int n, int original){
        if(n == 0){
            return true;
        }

        int digit = n % 10;
        sum = (sum * 10) + digit;
        isPalindromeRecursion(n / 10, original);

        return sum == original;
    }
}
