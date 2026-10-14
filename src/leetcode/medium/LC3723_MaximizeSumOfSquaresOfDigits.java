package leetcode.medium;

public class LC3723_MaximizeSumOfSquaresOfDigits {
    public static void main(String[] args) {
        LC3723_MaximizeSumOfSquaresOfDigits lc = new LC3723_MaximizeSumOfSquaresOfDigits();

        int num = 2;
        int sum = 17;

        System.out.println(lc.maxSumOfSquares(num, sum));
    }

//  Time Complexity - O(num)
    public String maxSumOfSquares(int num, int sum) {
        if(sum > 9 * num){
            return "";
        }

        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < num; i++){
            int digit = Math.min(9, sum);
            sb.append(digit);
            sum -= digit;
        }

        return sb.toString();
    }
}
