package backtracking;

public class CountPath {
    public static void main(String[] args) {
        System.out.println(countPath(3, 3));
    }

//    Counting all possible path
    static int countPath(int r, int c){
        int count = 0;
        if(r == 1  || c ==  1){
            return 1;
        }

        count += countPath( r - 1, c);
        count += countPath( r, c - 1);

        return count;
    }
}
