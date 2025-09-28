package LinkedList;

public class LengthOfLoopOptimal {
    public static class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public int lengthOfLoopOptimal(Node head) {
        Node slow = head;
        Node fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) {
                int count = 1;
                fast = fast.next;
                while (fast != slow) {
                    count++;
                    fast = fast.next;
                }
                return count;
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        // Create nodes
        Node n1 = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(3);
        Node n4 = new Node(4);
        Node n5 = new Node(5);
        Node n6 = new Node(6);
        Node n7 = new Node(7);

        // Link them: 1 -> 2 -> 3 -> 4 -> 5 -> 6 -> 7
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        n5.next = n6;
        n6.next = n7;

        // Create a loop: 7 -> 3  (loop is 3-4-5-6-7, length = 5)
        n7.next = n3;

        LengthOfLoopOptimal solver = new LengthOfLoopOptimal();
        int loopLen = solver.lengthOfLoopOptimal(n1);
        System.out.println("Loop length (should be 5): " + loopLen);

        // Break the loop
        n7.next = null;
        int noLoopLen = solver.lengthOfLoopOptimal(n1);
        System.out.println("Loop length (should be 0): " + noLoopLen);
    }
}
