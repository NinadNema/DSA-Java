package stack;

import java.util.Stack;

public class InBuiltStack {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();

        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);

        System.out.println("Stack: ");
        for (int i = stack.size() - 1; i >= 0; i--) {
            System.out.print(stack.get(i) + " ");
        }

        System.out.println();
        stack.pop();
        stack.pop();

        System.out.println("Stack After Pop: ");
        for (int i = stack.size() - 1; i >= 0; i--) {
            System.out.print(stack.get(i) + " ");
        }

        System.out.println();
        System.out.print("Stack Top Element: ");
        System.out.print(stack.peek());
    }
}
