package LinkedList.Problems;

import java.util.HashMap;

public class LengthOfLoopBrute {

    public static class Node{
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public static int lengthOfLoopHashing(Node head) {
        HashMap<Node, Integer> freq = new HashMap<>();
        Node temp = head;
        int timer = 0;
        while (temp != null) {
            timer++;
            if (freq.containsKey(temp)) {
                return timer - freq.get(temp);
            }
            freq.put(temp, timer);
            temp = temp.next;
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

        // Create a loop: 7 -> 3 (so loop nodes are 3,4,5,6,7 -> length 5)
        n7.next = n3;

        // Test: list with loop
        int loopLen = lengthOfLoopHashing(n1);
        System.out.println("Loop length (should be 5): " + loopLen);

        // Now test a list without loop
        n7.next = null; // break the loop
        int noLoopLen = lengthOfLoopHashing(n1);
        System.out.println("Loop length (should be 0): " + noLoopLen);
    }

}
