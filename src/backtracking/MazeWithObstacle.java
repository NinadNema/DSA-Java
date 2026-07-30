package backtracking;

public class MazeWithObstacle {
    public static void main(String[] args) {
        boolean[][] maze = {
                {true, true, true},
                {true, false, true},
                {true, false, true}
        };

        mazeWithObstacle("", 0, 0, maze);
    }
//  Printing Path with Obtracle using direction - Right and Down
    static void mazeWithObstacle(String p, int r, int c, boolean[][] maze){
        if(r == maze.length - 1 & c == maze[0].length - 1){
            System.out.println(p);
            return;
        }

        if(!maze[r][c]){
            return;
        }

        if(r < maze.length - 1){
            mazeWithObstacle(p + "D", r + 1, c, maze);
        }
        if(c < maze[0].length - 1){
            mazeWithObstacle(p + "R", r, c + 1, maze);
        }
    }
}
