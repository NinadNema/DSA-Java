package backtracking;

import java.util.Arrays;

public class AllPathMaze {
    public static void main(String[] args) {
        boolean[][] maze = {
                {true, true, true},
                {true, true, true},
                {true, true, true}
        };

        int[][] path = new int[maze.length][maze[0].length];

        allPath("", 0, 0, maze);
        allPathWithDirections("" , 0, 0, maze, path, 1);
    }

//    Printing Path using Direction - Right, Down, Left and Up
    static void allPath(String p, int r, int c, boolean[][] maze){
        if(r == maze.length - 1 & c == maze[0].length - 1){
            System.out.println(p);
            return;
        }

        if(!maze[r][c]){
            return;
        }

        maze[r][c] = false;

        if(r < maze.length - 1){
            allPath(p + "D", r + 1, c, maze);
        }
        if(c < maze[0].length - 1){
            allPath(p + "R", r, c + 1, maze);
        }

        if(c > 0){
            allPath(p + "L", r, c-1, maze);
        }

        if(r > 0){
            allPath(p + "U", r-1, c, maze);
        }

        maze[r][c] = true;
    }

//    Printing Path and Matrix using Direction - Right, Down, Left and Up
    static void allPathWithDirections(String p, int r, int c, boolean[][] maze, int[][] path, int step){
        if(r == maze.length - 1 & c == maze[0].length - 1){
            path[r][c] = step;
            for(int[] arr : path){
                System.out.println(Arrays.toString(arr));
            }
            System.out.println(p);
            System.out.println();
            return;
        }

        if(!maze[r][c]){
            return;
        }

        maze[r][c] = false;
        path[r][c] = step;
        if(r < maze.length - 1){
            allPathWithDirections(p + "D", r + 1, c, maze, path, step + 1);
        }
        if(c < maze[0].length - 1){
            allPathWithDirections(p + "R", r, c + 1, maze, path, step + 1);
        }

        if(c > 0){
            allPathWithDirections(p + "L", r, c-1, maze, path, step + 1);
        }

        if(r > 0){
            allPathWithDirections(p + "U", r-1, c, maze, path, step + 1);
        }

        maze[r][c] = true;
        path[r][c] = 0;
    }
}
