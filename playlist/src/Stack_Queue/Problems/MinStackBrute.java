package Stack_Queue.Problems;

import java.util.Stack;

public class MinStackBrute {
    private Stack<Integer> main;
    private Stack<Integer> minStack;

    // Constructor
    public MinStackBrute() {
        main = new Stack<>();
        minStack = new Stack<>();
    }

    // Push element onto the stack
    public void push(int x) {
        main.push(x);
        if(minStack.isEmpty() || x <= minStack.peek()) {
            minStack.push(x);
        } else {
            minStack.push(minStack.peek());
        }
    }

    // Remove the top element
    public void pop() {
        if(main.isEmpty()) {
            System.out.println("Stack Underflow");
            return;
        }
        main.pop();
        minStack.pop();
    }

    // Get the top element
    public int top() {
        if(main.isEmpty()) {
            throw new IllegalStateException("Stack is empty");
        }
        return main.peek();
    }

    // Retrieve the minimum element
    public int getMin() {
        if(main.isEmpty()) {
            throw new IllegalStateException("Stack is empty");
        }
        return minStack.peek();
    }

    // Get the size of the stack
    public int size() {
        return main.size();
    }
}
