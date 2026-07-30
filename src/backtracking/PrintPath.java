package backtracking;

import java.util.ArrayList;

public class PrintPath {
    public static void main(String[] args) {
        printPath(3, 3,  "");
        System.out.println();
        System.out.println(path("", 3, 3));
        System.out.println();
        printPathDiagonal(3, 3, "");
    }

//    Printing Path using direction Right and Down
    static void printPath(int r, int c, String p){
        if(r == 1 && c == 1){
            System.out.println(p);
            return;
        }

        if(r > 1) {
            printPath(r - 1, c, p + "D");
        }
        if(c > 1) {
            printPath(r, c - 1, p + "R");
        }
    }

//  Printing Path in ArrayList using direction Right and Down
    static ArrayList<String> path(String p , int r , int c){
        if(r == 1 && c == 1){
            ArrayList<String> list = new ArrayList<>();
            list.add(p);
            return list;
        }

        ArrayList<String> ans = new ArrayList<>();
        if(r > 1){
            ans.addAll(path(p + "D", r - 1, c));
        }

        if(c > 1){
            ans.addAll(path(p + "R", r, c - 1));
        }

        return ans;
    }

//    Printing Path using direction Right, Down and Diagonal
    static void printPathDiagonal(int r, int c, String p){
        if(r == 1 && c == 1){
            System.out.println(p);
            return;
        }

        if(r > 1) {
            printPathDiagonal(r - 1, c, p + "V");
        }
        if(c > 1) {
            printPathDiagonal(r, c - 1, p + "H");

        }
        if(r > 1 && c > 1){
            printPathDiagonal(r - 1, c - 1, p + "D");
        }
    }
}