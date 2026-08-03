package leetcode.hard;

import java.util.Arrays;

public class LC37_SudokuSolver {
    public static void main(String[] args) {
        char[][] board = {
                {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
                {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
        };

        solveSudoku(board);

        display(board);
    }

//    Time Complexity - O(9^m) where m - number of empty cell
    static void solveSudoku(char[][] board){
        solve(board);
    }

    static boolean solve(char[][] board){
        for (int row = 0; row < 9; row++) {
            for (int col = 0; col < 9; col++) {
                if(board[row][col] == '.'){
                    for(char ch = '1'; ch <= '9'; ch++) {
                        if (issafe(board, row, col, ch)) {
                            board[row][col] = ch;

                            if (solve(board)) {
                                return true;
                            }

                            board[row][col] = '.';
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }

    static boolean issafe(char[][] nums, int r, int c, char i){
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

        int startRow = r - (r % 3);
        int startCol = c - (c % 3);

        for (int j = startRow; j < startRow + 3; j++) {
            for (int k = startCol; k < startCol + 3; k++) {
                if(nums[j][k] == i){
                    return false;
                }
            }
        }

        return true;
    }

    static void display(char[][] nums){
        for(char[] num : nums){
            System.out.println(Arrays.toString(num));
        }
        System.out.println();
    }
}
