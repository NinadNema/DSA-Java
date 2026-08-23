package leetcode.medium;

public class LC1927_SumGame {
    public static void main(String[] args) {
        LC1927_SumGame lc = new LC1927_SumGame();

        String num = "?3295???";
        System.out.println(lc.sumGame(num));
    }

//  Method 1: Efficient Method
//  Time Complexity - O(n)
    public boolean sumGame(String num) {
        int n = num.length();
        int half = n / 2;

        int diff = 0;
        int leftQ = 0;
        int rightQ = 0;

        for (int i = 0; i < half; i++) {

            char ch = num.charAt(i);

            if (ch == '?') {
                leftQ++;
            } else {
                diff += ch - '0';
            }
        }

        for (int i = half; i < n; i++) {

            char ch = num.charAt(i);

            if (ch == '?') {
                rightQ++;
            } else {
                diff -= ch - '0';
            }
        }

        if ((leftQ + rightQ) % 2 == 1) {
            return true;
        }

        return diff != 9 * (rightQ - leftQ) / 2;
    }

//  Method 2: If the Constraint were Small
//  Time Complexity - O(2^n)
    public boolean sumGameSmall(String num) {
        return solve(num.toCharArray(), true);
    }

    public boolean solve(char[] num, boolean aliceTurn) {
        boolean hasQuestion = false;

        for (char ch : num) {
            if (ch == '?') {
                hasQuestion = true;
                break;
            }
        }

        if (!hasQuestion) {
            return isAliceWinner(num);
        }

        if (aliceTurn) {

            for (int i = 0; i < num.length; i++) {

                if (num[i] != '?') {
                    continue;
                }

                for (char digit = '0'; digit <= '9'; digit++) {

                    num[i] = digit;

                    if (solve(num, false)) {
                        num[i] = '?';
                        return true;
                    }
                }

                num[i] = '?';
            }

            return false;

        } else {
            for (int i = 0; i < num.length; i++) {

                if (num[i] != '?') {
                    continue;
                }

                for (char digit = '0'; digit <= '9'; digit++) {

                    num[i] = digit;

                    if (!solve(num, true)) {
                        num[i] = '?';
                        return false;
                    }
                }

                num[i] = '?';
            }
            return true;
        }
    }

    public boolean isAliceWinner(char[] num) {

        int half = num.length / 2;

        int left = 0;
        int right = 0;

        for (int i = 0; i < half; i++) {
            left += num[i] - '0';
        }

        for (int i = half; i < num.length; i++) {
            right += num[i] - '0';
        }

        return left != right;
    }
}