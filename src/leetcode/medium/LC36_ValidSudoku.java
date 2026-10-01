package leetcode.medium;

public class LC36_ValidSudoku {
    public static void main(String[] args) {
        LC36_ValidSudoku lc = new LC36_ValidSudoku();

        char[][] board = {
                {'5','3','.','.','7','.','.','.','.'},
                {'6','.','.','1','9','5','.','.','.'},
                {'.','9','8','.','.','.','.','6','.'},
                {'8','.','.','.','6','.','.','.','3'},
                {'4','.','.','8','.','3','.','.','1'},
                {'7','.','.','.','2','.','.','.','6'},
                {'.','6','.','.','.','.','2','8','.'},
                {'.','.','.','4','1','9','.','.','5'},
                {'.','.','.','.','8','.','.','7','9'}
        };

        System.out.println(lc.isValidSudoku(board));
    }

//  Time Complexity - O(1)
    public boolean isValidSudoku(char[][] board) {
        return helper(board, 0, 0);
    }

    boolean helper(char[][] board, int r, int c){
        if(r == 9){
            return true;
        }

        if(c == 9){
            return helper(board, r + 1, 0);
        }

        if(board[r][c] == '.'){
            return helper(board, r, c + 1);
        }

        char ch = board[r][c];

        if(!issafe(board, r, c, ch)){
            return false;
        }

        return helper(board, r, c + 1);
    }

    boolean issafe(char[][] board, int r, int c, char k){
        for (int i = 0; i < 9; i++) {
            if(i != c && board[r][i] == k){
                return false;
            }
        }

        for (int i = 0; i < 9; i++) {
            if(i != r && board[i][c] == k){
                return false;
            }
        }

        int idx1 = r - (r % 3);
        int idx2 = c - (c % 3);

        for (int i = idx1; i < idx1 + 3; i++) {
            for (int j = idx2; j < idx2 + 3; j++) {
                if((i != r || j != c) && board[i][j] == k){
                    return false;
                }
            }
        }

        return true;
    }
}
