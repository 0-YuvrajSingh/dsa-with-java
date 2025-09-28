package Stack_Queue.Queue_Implementation;

public class QueueUsingArray {
    public static class Queue {
        int size = 4;
        int[] queue = new int[size];
        int start = -1;
        int end = -1;
        int currSize = 0;

        // enqueue
        public void enqueue(int x) {
            if (currSize == size) {
                System.out.println("Overflow");
                return;
            }
            if (currSize == 0) {
                start = 0;
                end = 0;
            } else {
                end = (end + 1) % size;
            }
            queue[end] = x;
            currSize++;
        }

        // dequeue
        public int dequeue() {
            if (currSize == 0) {
                System.out.println("Underflow");
                return -1;
            }
            int element = queue[start];
            if (currSize == 1) {
                start = -1;
                end = -1;
            } else {
                start = (start + 1) % size;
            }
            currSize--;
            return element;
        }

        // peek (front element)
        public int front() {
            if (start == -1) {
                System.out.println("Empty");
                return -1;
            }
            return queue[start];
        }

        // size
        public int size() {
            return currSize;
        }

        // check empty
        public boolean isEmpty() {
            return currSize == 0;
        }
    }

    // driver
    public static void main(String[] args) {
        Queue q = new Queue();

        q.enqueue(10);
        q.enqueue(20);
        q.enqueue(30);

        System.out.println("Front: " + q.front()); // 10
        System.out.println("Dequeued: " + q.dequeue()); // 10
        System.out.println("Front after dequeue: " + q.front()); // 20
        System.out.println("Size: " + q.size()); // 2
    }
}
