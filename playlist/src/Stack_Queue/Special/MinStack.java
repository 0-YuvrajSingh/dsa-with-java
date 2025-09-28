package Stack_Queue.Special;

import java.util.Stack;

/**
 * Optimized MinStack Implementation
 *
 * Supports push, pop, peek, and getMin operations in O(1) time
 * without using extra space for an additional stack.
 */
public class MinStack {

    private Stack<Integer> stack; // Main stack to store elements
    private int min; // Current minimum element in the stack

    // Constructor
    public MinStack() {
        stack = new Stack<>();
    }

    /**
     * Pushes an element onto the stack.
     * If the element is smaller than the current minimum,
     * stores a modified value to track previous minimum.
     */
    public void push(int val) {
        if(stack.isEmpty()) {
            min = val;
            stack.push(val);
        } else {
            if(val > min) {
                stack.push(val); // Normal push
            } else {
                // Store modified value and update min
                stack.push(2 * val - min);
                min = val;
            }
        }
    }

    /**
     * Pops the top element from the stack.
     * If the popped element was a modified value,
     * restores the previous minimum.
     */
    public void pop() {
        if(stack.isEmpty()) return;

        int top = stack.pop();

        if(top < min) {
            // Restore previous minimum
            min = 2 * min - top;
        }
    }

    /**
     * Returns the top element of the stack without removing it.
     * If the top is a modified value, returns the current minimum.
     */
    public int peek() {
        if(stack.isEmpty()) return -1;

        int top = stack.peek();
        return (top >= min) ? top : min;
    }

    /**
     * Returns the current minimum element in the stack.
     */
    public int getMin() {
        if(stack.isEmpty()) return -1;
        return min;
    }

    // --- Main method to test MinStack ---
    public static void main(String[] args) {
        MinStack minStack = new MinStack();

        minStack.push(5);
        System.out.println("Push 5, Min: " + minStack.getMin()); // 5
        minStack.push(3);
        System.out.println("Push 3, Min: " + minStack.getMin()); // 3
        minStack.push(7);
        System.out.println("Push 7, Min: " + minStack.getMin()); // 3
        minStack.push(2);
        System.out.println("Push 2, Min: " + minStack.getMin()); // 2

        System.out.println("Peek: " + minStack.peek()); // 2
        minStack.pop();
        System.out.println("Pop, Min: " + minStack.getMin()); // 3
        minStack.pop();
        System.out.println("Pop, Min: " + minStack.getMin()); // 3
        minStack.pop();
        System.out.println("Pop, Min: " + minStack.getMin()); // 5
    }
}
