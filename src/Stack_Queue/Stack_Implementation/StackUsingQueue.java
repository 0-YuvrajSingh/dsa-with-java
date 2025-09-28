package Stack_Queue.Stack_Implementation;

import java.util.LinkedList;
import java.util.Queue;

public class StackUsingQueue {
    static Queue<Integer> queue = new LinkedList<>();

    // Push element
    public static void push(int x) {
        int n = queue.size();
        queue.add(x);

        // Rotate previous elements
        for (int i = 0; i < n; i++) {
            queue.add(queue.remove());
        }
    }

    // Pop element
    public static int pop() {
        if (queue.isEmpty()) {
            System.out.println("Underflow");
            return -1;
        }
        return queue.remove();
    }

    // Top element
    public static int top() {
        if (queue.isEmpty()) {
            System.out.println("Empty");
            return -1;
        }
        return queue.peek();
    }

    // Size
    public static int size() {
        return queue.size();
    }

    // Check empty
    public static boolean isEmpty() {
        return queue.isEmpty();
    }

    // Test
    public static void main(String[] args) {
        push(10);
        push(20);
        push(30);

        System.out.println("Top: " + top()); // 30
        System.out.println("Pop: " + pop()); // 30
        System.out.println("Top: " + top()); // 20
        System.out.println("Size: " + size()); // 2
        System.out.println("Is empty? " + isEmpty()); // false
    }
}
