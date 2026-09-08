package leetcode.easy;

public class LC3870_CountCommasInRange {
    public static void main(String[] args) {
        LC3870_CountCommasInRange lc = new LC3870_CountCommasInRange();

        int n = 1002;
        System.out.println(lc.countCommas(n));
    }

//  Time Complexity - O(1)
    public int countCommas(int n) {
        if(n >= 1000){
            return (n - 1000) + 1;
        }
        return 0;
    }
}
