package Stack_Queue.Queue_Implementation;

public class QueueUsingLinkedList {
    public static class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public static class Queue {
        Node front = null;
        Node rear = null;
        int size = 0;

        public void enqueue(int x) {
            Node temp = new Node(x);
            if (front == null) {
                front = temp;
                rear = temp;
            } else {
                rear.next = temp;
                rear = temp;
            }
            size++;
        }

        public void dequeue() {
            if (front == null) {
                System.out.println("Underflow");
                return;
            }
            Node temp = front;
            front = front.next;
            if (front == null) { // queue became empty
                rear = null;
            }
            temp = null;
            size--;
        }

        public int peek() {
            if (front == null) {
                System.out.println("Queue is empty");
                return -1;
            }
            return front.data;
        }

        public int size() {
            return size;
        }
    }

    // ----------------- Testing -----------------
    public static void main(String[] args) {
        Queue q = new Queue();

        q.enqueue(10);
        q.enqueue(20);
        q.enqueue(30);

        System.out.println("Front element: " + q.peek()); // 10
        System.out.println("Queue size: " + q.size());    // 3

        q.dequeue(); // removes 10
        System.out.println("Front element after dequeue: " + q.peek()); // 20

        q.dequeue(); // removes 20
        q.dequeue(); // removes 30
        q.dequeue(); // Underflow

        System.out.println("Queue size: " + q.size()); // 0
    }
}
