package backtracking;

import java.util.Arrays;

public class SudokuSolver {
    public static void main(String[] args) {
        int[][] board = {
                {5, 3, 0, 0, 7, 0, 0, 0, 0},
                {6, 0, 0, 1, 9, 5, 0, 0, 0},
                {0, 9, 8, 0, 0, 0, 0, 6, 0},
                {8, 0, 0, 0, 6, 0, 0, 0, 3},
                {4, 0, 0, 8, 0, 3, 0, 0, 1},
                {7, 0, 0, 0, 2, 0, 0, 0, 6},
                {0, 6, 0, 0, 0, 0, 2, 8, 0},
                {0, 0, 0, 4, 1, 9, 0, 0, 5},
                {0, 0, 0, 0, 8, 0, 0, 7, 9}
        };

        sudokuSolver(board, 0, 0);
    }

//  Time Complexity - O(9^m) where m - number of empty cell
    static int sudokuSolver(int[][] nums, int r, int c){
        if(r == 9){
            display(nums);
            System.out.println();
            return 1;
        }

        if(c == 9){
            return sudokuSolver(nums, r + 1, 0);
        }

        if(nums[r][c] != 0) {
           return sudokuSolver(nums, r, c + 1);
        }

        int count = 0;
        if(nums[r][c] == 0){
            for (int i = 1; i <= 9; i++) {
                if(isSafe(nums, r, c, i)){
                    nums[r][c] = i;
                    count += sudokuSolver(nums, r, c + 1);
                    nums[r][c] = 0;
                }
            }
        }

        return count;
    }

    static boolean isSafe(int[][] nums, int r, int c, int i){
        for (int j = 0; j < 9; j++) {
            if(nums[r][j] == i){
                return false;
            }
        }

        for (int j = 0; j < 9; j++) {
            if(nums[j][c] == i){
                return false;
            }
        }

        int idx1 = r - (r % 3);
        int idx2 = c - (c % 3);

        for (int j = idx1; j < idx1 + 3; j++) {
            for (int k = idx2; k < idx2 + 3; k++) {
                if(nums[j][k] == i){
                    return false;
                }
            }
        }

        return true;
    }

    static void display(int[][] nums){
        for(int[] num : nums){
            System.out.println(Arrays.toString(num));
        }
        System.out.println();
    }
}
