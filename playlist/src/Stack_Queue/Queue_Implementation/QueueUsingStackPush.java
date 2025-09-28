package Stack_Queue.Queue_Implementation;

import java.util.Stack;

public class QueueUsingStackPush {
    Stack<Integer> s1 = new Stack<>();
    Stack<Integer> s2 = new Stack<>();

    // Enqueue is simple: O(1)
    public void enqueue(int x) {
        s1.push(x);
    }

    // Dequeue: O(n) when s2 is empty
    public int dequeue() {
        if (s2.isEmpty()) {
            while (!s1.isEmpty()) {
                s2.push(s1.pop());
            }
        }

        if (s2.isEmpty()) {
            System.out.println("Underflow");
            return -1;
        }

        return s2.pop();
    }

    // Peek front element
    public int top() {
        if (s2.isEmpty()) {
            while (!s1.isEmpty()) {
                s2.push(s1.pop());
            }
        }

        if (s2.isEmpty()) {
            System.out.println("Empty");
            return -1;
        }

        return s2.peek(); // don't remove, just view
    }

    // Size of queue
    public int size() {
        return s1.size() + s2.size();
    }

    // Test
    public static void main(String[] args) {
        QueueUsingStackPush q = new QueueUsingStackPush();

        q.enqueue(10);
        q.enqueue(20);
        q.enqueue(30);

        System.out.println("Front: " + q.top());     // 10
        System.out.println("Dequeue: " + q.dequeue()); // 10
        System.out.println("Front after dequeue: " + q.top()); // 20
        System.out.println("Size: " + q.size());     // 2
    }
}
