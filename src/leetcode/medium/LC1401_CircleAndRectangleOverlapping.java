package leetcode.medium;

public class LC1401_CircleAndRectangleOverlapping {
    public static void main(String[] args) {
        LC1401_CircleAndRectangleOverlapping lc = new LC1401_CircleAndRectangleOverlapping();

        int radius = 1;
        int xCenter = 0;
        int yCenter = 0;
        int x1 = 1;
        int y1 = -1;
        int x2 = 3;
        int y2 = 1;

        System.out.println(lc.checkOverlap(radius, xCenter, yCenter, x1, y1, x2, y2));
    }

//  Time Complexity - O(1)
    public boolean checkOverlap(int radius, int xCenter, int yCenter, int x1, int y1, int x2, int y2) {
        int closestX = Math.max(x1, Math.min(xCenter, x2));
        int closestY = Math.max(y1, Math.min(yCenter, y2));

        int dx = xCenter - closestX;
        int dy = yCenter - closestY;

        return dx * dx + dy * dy <= radius * radius;
    }
}
