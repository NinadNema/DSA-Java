package leetcode.easy;

import java.util.Stack;

public class LC232_ImplementQueueStacks {
    public static void main(String[] args){
        MyQueue obj = new MyQueue();
        obj.push(1);
        obj.push(2);

        System.out.println(obj.peek());
        System.out.println(obj.pop());
        System.out.println(obj.empty());
    }
}

class MyQueue {
    Stack<Integer> stack1;
    Stack<Integer> stack2;

    MyQueue(){
        stack1 = new Stack<>();
        stack2 = new Stack<>();
    }

//  Time Complexity - O(1)
    public void push(int x) {
        stack1.push(x);
    }

//  Time Complexity - O(n)
    public int pop(){
        while(!stack1.isEmpty()){
            stack2.push(stack1.pop());
        }

        int remove = stack2.pop();

        while(!stack2.isEmpty()){
            stack1.push(stack2.pop());
        }

        return remove;
    }

//  Time Complexity - O(n)
    public int peek(){
        while(!stack1.isEmpty()){
            stack2.push(stack1.pop());
        }

        int firstEle = stack2.peek();

        while(!stack2.isEmpty()){
            stack1.push(stack2.pop());
        }

        return firstEle;
    }

//  Time Complexity - O(1)
    public boolean empty() {
        return stack1.isEmpty();
    }
}
