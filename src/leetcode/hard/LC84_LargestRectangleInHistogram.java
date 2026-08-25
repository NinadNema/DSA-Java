package leetcode.hard;

import java.util.Stack;

public class LC84_LargestRectangleInHistogram {
    public static void main(String[] args) {
        LC84_LargestRectangleInHistogram lc = new LC84_LargestRectangleInHistogram();
        int[] arr = {2,1,5,6,2,3};

        System.out.println(lc.largestRectangleArea(arr));
        System.out.println(lc.largestRectangleAreaBruteForce(arr));
    }
//  Method 1: Brute Force
//  Time Complexity - O(n^2)
    public int largestRectangleAreaBruteForce(int[] heights){
        int maxArea = 0;

        for (int i = 0; i < heights.length; i++) {
            int minHeight = heights[i];

            for (int j = i; j < heights.length; j++) {
                minHeight = Math.min(minHeight, heights[j]);

                int width = j - i + 1;
                int area = minHeight * width;

                maxArea = Math.max(maxArea, area);
            }
        }
        return maxArea;
    }

//  Method 2: Monotonic Stack
//  Time Complexity - O(n)
    public int largestRectangleArea(int[] heights) {
        Stack<Integer> stack = new Stack<>();

        int max = 0;

        stack.push(0);

        for (int i = 1; i < heights.length; i++) {
            while(!stack.isEmpty() && heights[i] < heights[stack.peek()]){
                max = getMax(heights, stack, max, i);
            }
            stack.push(i);
        }

        int i = heights.length;
        while(!stack.isEmpty()){
            max = getMax(heights, stack, max, i);
        }
        return max;
    }

    private int getMax(int[] heights, Stack<Integer> stack, int max, int i){
        int area;
        int poped = stack.pop();

        if(stack.isEmpty()){
            area = heights[poped] * i;
        }else{
            area = heights[poped] * (i - 1 - stack.peek());
        }

        return Math.max(area, max);
    }
}
