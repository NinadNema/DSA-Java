package searching;

import java.util.Arrays;

public class RowColMatrix {
    public static void main(String[] args) {
        int[][] arr = {
                {10, 20, 30 ,40},
                {15, 25, 35, 45},
                {28, 29, 37, 49},
                {33, 34, 38, 50}
        };

        System.out.println(Arrays.toString(search(arr, 50)));
    }

    static int[] search(int[][] num, int target){
        int row = 0;
        int col = num.length-1;

        while(row < num.length && col >= 0){
            if (num[row][col] == target){
                return new int[] {row, col};
            }
            if(target < num[row][col]){
                col--;
            }else{
                row++;
            }
        }
        return new int[] {-1,-1};
    }
}
