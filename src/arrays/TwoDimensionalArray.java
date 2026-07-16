package arrays;

import java.util.Arrays;
import java.util.Scanner;

public class TwoDimensionalArray {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Normal 2D Array
        int[][] num = new int[3][3];

        /*
        // Jagged Array
        int[][] num = new int[3][];
        num[0] = new int[3];
        num[1] = new int[2];
        num[2] = new int[4];
        */

        for (int i = 0; i < num.length; i++) {
            for (int j = 0; j < num[i].length; j++) {
                num[i][j] = sc.nextInt();
            }
        }

        for (int[] row : num) {
            System.out.println(Arrays.toString(row));
        }

        sc.close();
    }
}