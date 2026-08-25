package stack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


// HakerRank Question: Game of Two Stack
public class GameOfTwoStack {
    public static void main(String[] args) {
        GameOfTwoStack gs = new GameOfTwoStack();

        int[] c = {4, 2, 4, 6, 1};
        int[] d = {2, 1, 8, 5};

        List<Integer> a = new ArrayList<>();
        List<Integer> b = new ArrayList<>();

        a.add(4);
        a.add(2);
        a.add(4);
        a.add(6);
        a.add(1);

        b.add(2);
        b.add(1);
        b.add(8);
        b.add(5);

        System.out.println(gs.gameStack(10, c, d, 0, 0));
        System.out.println(twoStacks(10, a, b));
    }

//  Using Arrays
//  Time Complexity - O(2^n)
    public int gameStack(int maxSum, int[] a, int[] b, int sum, int count){
        if(sum > maxSum){
            return count - 1;
        }

        if(a.length == 0 || b.length == 0){
            return count - 1;
        }

        int ans1 = gameStack(maxSum, Arrays.copyOfRange(a, 1, a.length), b, sum + a[0], count + 1);
        int ans2 = gameStack(maxSum, a, Arrays.copyOfRange(b, 1, b.length) , sum + b[0], count + 1);

        return Math.max(ans1, ans2);
    }

//  Using List
//  Time Complexity - O(2^n)
    public static int twoStacks(int maxSum, List<Integer> a, List<Integer> b){
        return twoStacks(maxSum, a, b, 0, 0) - 1;
    }

    private static int twoStacks(int maxSum, List<Integer> a, List<Integer> b, int sum, int count){
        if(sum > maxSum){
            return count;
        }

        if(a.isEmpty() || b.isEmpty()){
            return count;
        }

        int ans1 = twoStacks(maxSum, a.subList(1, a.size()), b, sum + a.getFirst(), count + 1);
        int ans2 = twoStacks(maxSum, a, b.subList(1, b.size()), sum + b.getFirst(), count + 1);

        return Math.max(ans1, ans2);
    }
}
