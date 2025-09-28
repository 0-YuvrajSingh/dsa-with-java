package Stack_Queue.Stack_Implementation;

public class StackUsingLinkedList {

    public static class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public static class Stack {
        Node top;
        int size = 0;

        // push
        public void push(int x) {
            Node temp = new Node(x);
            temp.next = top;
            top = temp;
            size++;
        }

        // pop
        public int pop() {
            if (top == null) {
                System.out.println("Underflow");
                return -1;
            }
            int popped = top.data;
            top = top.next;
            size--;
            return popped;
        }

        // peek
        public int peek() {
            if (top == null) {
                System.out.println("Stack is empty");
                return -1;
            }
            return top.data;
        }

        // size
        public int size() {
            return size;
        }

        // isEmpty
        public boolean isEmpty() {
            return size == 0;
        }
    }

    // driver
    public static void main(String[] args) {
        Stack st = new Stack();

        st.push(10);
        st.push(20);
        st.push(30);

        System.out.println("Top element: " + st.peek());   // 30
        System.out.println("Popped: " + st.pop());        // 30
        System.out.println("Top after pop: " + st.peek()); // 20
        System.out.println("Stack size: " + st.size());    // 2
    }
}
