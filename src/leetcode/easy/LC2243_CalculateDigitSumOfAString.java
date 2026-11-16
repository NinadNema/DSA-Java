package leetcode.easy;

public class LC2243_CalculateDigitSumOfAString {
    public static void main(String[] args) {
        LC2243_CalculateDigitSumOfAString lc = new LC2243_CalculateDigitSumOfAString();

        String s = "11111222223";
        int k = 3;

        System.out.println(lc.digitSum(s, k));
    }

//  Time Complexity - O(n log n)
    public String digitSum(String s, int k) {
        while (s.length() > k) {

            StringBuilder next = new StringBuilder();

            for (int i = 0; i < s.length(); i += k) {

                int sum = 0;

                for (int j = i; j < Math.min(i + k, s.length()); j++) {
                    sum += s.charAt(j) - '0';
                }

                next.append(sum);
            }

            s = next.toString();
        }

        return s;
    }
}
