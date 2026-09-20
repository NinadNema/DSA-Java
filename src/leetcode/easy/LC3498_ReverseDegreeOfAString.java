package leetcode.easy;

public class LC3498_ReverseDegreeOfAString {
    public static void main(String[] args) {
        LC3498_ReverseDegreeOfAString lc = new LC3498_ReverseDegreeOfAString();

        String s = "zaza";

        System.out.println(lc.reverseDegree(s));
    }

//  Time Complexity - O(n)
    public int reverseDegree(String s) {
        char[] ch = s.toCharArray();

        int sum = 0;

        for(int i = 0; i < ch.length; i++){
            int sq = Math.abs(ch[i] - 'a' - 26);
            sum += (i + 1) * sq;
        }

        return sum;
    }
}