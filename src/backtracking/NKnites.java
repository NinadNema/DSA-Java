package backtracking;

public class NKnites {
    public static void main(String[] args) {
        int n = 4;
        boolean[][] board = new boolean[n][n];

        System.out.println(nKnight(board, 0, 0, n));
    }

//  Time Complexity - O(2^N^2)
    static int nKnight(boolean[][] board, int r, int c, int knights){
        if(knights == 0){
            display(board);
            System.out.println();
            return 1;
        }

        int count = 0;

        if(r == board.length){
            return 0;
        }

        if(c == board.length){
            count += nKnight(board, r + 1, 0,  knights);
            return count;
        }

        if(isSafe(board, r, c)){
            board[r][c] = true;
            count += nKnight(board, r, c + 1,  knights - 1);
            board[r][c] = false;
        }

        count += nKnight(board, r, c + 1,  knights);

        return count;
    }

    static boolean isSafe(boolean[][] board, int r, int c){
        if(isValid(board, r - 2, c - 1)){
            if(board[r - 2][c - 1]){
                return false;
            }
        }

        if(isValid(board, r - 2, c + 1)){
            if(board[r - 2][c + 1]){
                return false;
            }
        }

        if(isValid(board, r - 1, c - 2)){
            if(board[r - 1][c - 2]){
                return false;
            }
        }

        if (isValid(board, r - 1, c + 2)) {
            if (board[r - 1][c + 2]) {
                return false;
            }
        }

        return true;
    }


    static boolean isValid(boolean[][] board, int r, int c){
        return r >= 0 && r < board.length && c >= 0 && c < board.length;
    }

    static void display(boolean[][] board){
        for(boolean[] row : board){
            for(boolean ele : row){
                if(ele){
                    System.out.print("K ");
                }else{
                    System.out.print("X ");
                }
            }
            System.out.println();
        }
    }
}
