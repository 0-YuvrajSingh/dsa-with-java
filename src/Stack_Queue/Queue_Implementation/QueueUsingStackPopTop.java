package Stack_Queue.Queue_Implementation;

import java.util.Stack;

public class QueueUsingStackPopTop {
    Stack<Integer> s1 = new Stack<>();
    Stack<Integer> s2 = new Stack<>();

    // Enqueue (push into queue)
    public void enqueue(int x) {
        // Move all from s1 to s2
        while (!s1.isEmpty()) {
            s2.push(s1.pop());
        }

        // Push new element into s1
        s1.push(x);

        // Move everything back to s1
        while (!s2.isEmpty()) {
            s1.push(s2.pop());
        }
    }

    // Dequeue (remove from front)
    public int dequeue() {
        if (s1.isEmpty()) {
            System.out.println("Underflow");
            return -1;
        }
        return s1.pop();
    }

    // Peek (front element)
    public int peek() {
        if (s1.isEmpty()) {
            System.out.println("Empty");
            return -1;
        }
        return s1.peek();
    }

    // Size
    public int size() {
        return s1.size();
    }

    // Test
    public static void main(String[] args) {
        QueueUsingStackPopTop q = new QueueUsingStackPopTop();

        q.enqueue(10);
        q.enqueue(20);
        q.enqueue(30);

        System.out.println("Front: " + q.peek()); // 10
        System.out.println("Dequeue: " + q.dequeue()); // 10
        System.out.println("Front after dequeue: " + q.peek()); // 20
        System.out.println("Size: " + q.size()); // 2
    }
}
