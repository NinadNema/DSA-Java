package recursion;

public class CountZero {
    public static void main(String[] args) {
        int n = 30204;

        System.out.println(zero(n));
        System.out.println(zeroRecursion(n));
    }

    static int zero(int n){
        int count = 0;
        while( n > 0){
            int digit = n % 10;
            if(digit == 0){
                count++;
            }
            n /= 10;
        }
        return count;
    }

    static int count = 0;
    static int zeroRecursion(int n){
        if(n == 0){
            return count;
        }

        int digit = n % 10;
        if(digit == 0){
            count++;
        }
        zeroRecursion(n / 10);

        return count;
    }
}
