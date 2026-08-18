package leetcode.easy;

public class LC202_HappyNumber {
    public static void main(String[] args) {
        LC202_HappyNumber lc = new LC202_HappyNumber();
        int n = 12;

        System.out.println(lc.isHappy(n));
    }

    public boolean isHappy(int n){
        int slow = n;
        int fast = n;

        do{
            slow = findSquare(slow);
            fast = findSquare(findSquare(fast));
        }while(slow != fast);

        return slow == 1;
    }

    private int findSquare(int n) {
        int sum = 0;
        while(n > 0){
            int digit = n % 10;
            sum += (int) Math.pow(digit, 2);
            n /= 10;
        }
        return sum;
    }
}
