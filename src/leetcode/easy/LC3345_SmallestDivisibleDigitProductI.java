package leetcode.easy;

public class LC3345_SmallestDivisibleDigitProductI {
    public static void main(String[] args) {
        int n = 37;
        int t = 6;

        System.out.println(smallestNumber(n, t));
    }

//  Time Complexity - O(N)
    static int smallestNumber(int n, int t) {

        if(product(n) % t == 0){
            return n;
        }else{
            while(true){
                if(product(n) % t == 0){
                    return n;
                }
                n++;
            }
        }
    }

    static int product(int n){
        int prod = 1;

        while(n > 0){
            int digit = n % 10;
            prod *= digit;
            n /= 10;
        }
        return prod;
    }
}
