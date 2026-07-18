package searching;

import java.util.Arrays;

public class SortedMatrix {
    public static void main(String[] args) {
        int[][] arr = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
        System.out.println(Arrays.toString(search(arr, 9)));
    }

    static int[] search(int[][] matrix, int target) {
        int n = matrix.length;
        int m = matrix[0].length;

        int low = 0;
        int high = n * m-1;

        while(low <= high){
            int mid = low + (high-low) /2 ;
            int row = mid/m;
            int col = mid%m;

            int ele = matrix[row][col];
            if(ele == target){
                return new int[] {row,col};
            }

            if(ele < target){
                low = mid + 1;
            }
            else{
                high = mid -1;
            }
        }
        return new int[] {-1,-1};
    }
}
