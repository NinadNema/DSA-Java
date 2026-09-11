package leetcode.easy;

public class LC3483_Unique3DigitEvenNumbers {
    public static void main(String[] args) {
        LC3483_Unique3DigitEvenNumbers lc = new LC3483_Unique3DigitEvenNumbers();

        int[] arr = {1,2,3,4};

        System.out.println(lc.totalNumbers(arr));
    }

//  Time Complexity - O(900 * 10) = O(1)
    public int totalNumbers(int[] digits) {
        int[] freq = new int[10];

        for (int digit : digits) {
            freq[digit]++;
        }

        int count = 0;

        for (int num = 100; num <= 999; num++) {

            if (num % 2 != 0) {
                continue;
            }

            int a = num / 100;
            int b = (num / 10) % 10;
            int c = num % 10;

            int[] used = new int[10];

            used[a]++;
            used[b]++;
            used[c]++;

            boolean possible = true;

            for (int i = 0; i < 10; i++) {
                if (used[i] > freq[i]) {
                    possible = false;
                    break;
                }
            }

            if (possible) {
                count++;
            }
        }

        return count;
    }
}
