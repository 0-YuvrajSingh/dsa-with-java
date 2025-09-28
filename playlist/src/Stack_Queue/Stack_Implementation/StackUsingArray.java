package Stack_Queue.Stack_Implementation;

public class StackUsingArray {
    // Inner static class for Stack
    public static class Stack {
        int n = 10;               // capacity
        int[] stack = new int[n]; // array
        int top = -1;

        // push
        public void push(int x) {
            if (top >= n - 1) {
                System.out.println("Overflow");
            } else {
                stack[++top] = x;
            }
        }

        // pop
        public int pop() {
            if (top == -1) {
                System.out.println("Underflow");
                return -1;
            }
            return stack[top--];
        }

        // peek
        public int peek() {
            if (top == -1) {
                System.out.println("Stack is empty");
                return -1;
            }
            return stack[top];
        }

        // size
        public int size() {
            return top + 1;
        }

        // check empty
        public boolean isEmpty() {
            return top == -1;
        }
    }

    // driver code
    public static void main(String[] args) {
        Stack st = new Stack();

        st.push(10);
        st.push(20);
        st.push(30);

        System.out.println("Top element: " + st.peek()); // 30
        System.out.println("Size: " + st.size());        // 3
        System.out.println("Popped: " + st.pop());       // 30
        System.out.println("Size after pop: " + st.size()); // 2
    }
}
