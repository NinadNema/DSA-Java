package recursion;

public class ReverseNumber {
    public static void main(String[] args) {
        int n = 451;
        System.out.println(rev_itersative(n));
        System.out.println(rev_method_1(n));
    }

    static int rev_itersative(int n){
        int rev = 0;
        while(n > 0){
            int digit = n % 10;
            rev = (rev * 10) + digit;
            n /= 10;
        }
        return rev;
    }

    static int sum = 0;
    static int rev_method_1(int n){
        if(n == 0){
            return n;
        }

        int rem = n % 10;
        sum = (sum * 10) + rem;
        rev_method_1(n / 10);

        return sum;
    }


}
