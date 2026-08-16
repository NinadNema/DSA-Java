package leetcode.medium;

public class LC2029_StoneGameIX {
    public static void main(String[] args){
        LC2029_StoneGameIX lc = new LC2029_StoneGameIX();
        int[] stones = {5,1,2,4,3};

        System.out.println(lc.stoneGameIX(stones));
    }

//  Time Complexity - O(n)
    public boolean stoneGameIX(int[] stones){
        int[] count = new int[3];

        for (int stone : stones) {
            count[stone % 3]++;
        }

        if (count[0] % 2 == 0) {
            return count[1] > 0 && count[2] > 0;
        }

        return Math.abs(count[1] - count[2]) >= 3;
    }
}
