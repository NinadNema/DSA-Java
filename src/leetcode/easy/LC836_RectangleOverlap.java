package leetcode.easy;

public class LC836_RectangleOverlap {
    public static void main(String[] args) {
        LC836_RectangleOverlap lc = new LC836_RectangleOverlap();

        int[] rec1 = {0,0,1,1};
        int[] rec2 = {1,0,2,1};

        System.out.println(lc.isRectangleOverlap(rec1, rec2));
    }

//  Time Complexity - O(1)
    public boolean isRectangleOverlap(int[] rec1, int[] rec2) {
        return rec1[2] > rec2[0] && rec1[0] < rec2[2] && rec1[3] > rec2[1] && rec1[1] < rec2[3];
    }
}
