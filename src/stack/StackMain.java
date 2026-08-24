package stack;

public class StackMain {
    public static void main(String[] args) throws Exception {
        CustomStack stack = new CustomStack(5);

        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);

        System.out.println("Element at the top of Stack: ");
        System.out.println(stack.peek());

        System.out.println();
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
//        System.out.println(stack.pop());
    }
}
