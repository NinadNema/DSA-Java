package leetcode.medium;

public class LC835_ImageOverlap {
    public static void main(String[] args) {
        LC835_ImageOverlap lc = new LC835_ImageOverlap();
        int[][] img1 = {{1,1,0}, {0,1,0}, {0,1,0}};
        int[][] img2 = {{0,0,0}, {0,1,1}, {0,0,1}};

        System.out.println(lc.largestOverlap(img1, img2));
    }

//  Time Complexity - O(n^2)
    public int largestOverlap(int[][] img1, int[][] img2) {
        int n = img1.length;
        int max = 0;

        for (int rowShift = -(n - 1); rowShift <= n - 1; rowShift++) {

            for (int colShift = -(n - 1); colShift <= n - 1; colShift++) {

                int overlap = 0;

                for (int i = 0; i < n; i++) {
                    for (int j = 0; j < n; j++) {

                        if (img1[i][j] == 1) {

                            int newRow = i + rowShift;
                            int newCol = j + colShift;

                            if (newRow >= 0 && newRow < n && newCol >= 0 && newCol < n && img2[newRow][newCol] == 1) {
                                overlap++;
                            }
                        }
                    }
                }

                max = Math.max(max, overlap);
            }
        }

        return max;
    }
}
