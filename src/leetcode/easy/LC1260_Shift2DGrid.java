package leetcode.easy;

import java.util.*;
public class LC1260_Shift2DGrid {
    public static void main(String[] args) {
        int[][] grid = {{1,2},{3, 4}};

        for(List<Integer> i : shiftGrid(grid, 1)){
            System.out.println(i);
        }
    }

    static  List<List<Integer>> shiftGrid(int[][] grid, int k){
        int n = grid[0].length;
        int m = grid.length;
        int[][] answer = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {

                int index = i * n + j;

                int newIndex = (index + k) % (m * n);

                int newRow = newIndex / n;
                int newCol = newIndex % n;

                answer[newRow][newCol] = grid[i][j];
            }
        }

        List<List<Integer>> ans = new ArrayList<>();

        for (int i = 0; i < m; i++) {
            List<Integer> row = new ArrayList<>();
            for (int j = 0; j < n; j++) {
                row.add(answer[i][j]);
            }
            ans.add(row);
        }

        return ans;
    }
}
