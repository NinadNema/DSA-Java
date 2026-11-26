package leetcode.easy;

public class LC3360_StoneRemovalGame {
    public static void main(String[] args) {
        LC3360_StoneRemovalGame lc = new LC3360_StoneRemovalGame();

        int n = 12;

        System.out.println(lc.canAliceWin(n));
    }

//  Time Complexity - O(1)
    public boolean canAliceWin(int n) {
        int remove = 10;
        boolean alice = true;

        while (n >= remove) {
            n -= remove;
            remove--;
            alice = !alice;
        }

        return !alice;
    }
}
