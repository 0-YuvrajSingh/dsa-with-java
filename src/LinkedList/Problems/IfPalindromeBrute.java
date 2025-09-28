package LinkedList.Problems;

import java.util.Stack;

public class IfPalindromeBrute {

    public class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public boolean ifPalindrome(Node head) {
        Stack<Integer> stack = new Stack<>();
        Node curr = head;

        // Push all elements into stack
        while (curr != null) {
            stack.push(curr.data);
            curr = curr.next;
        }

        // Compare with stack
        Node temp = head;
        while (temp != null) {
            if (temp.data == stack.peek()) {
                stack.pop();
                temp = temp.next;
            } else {
                return false;
            }
        }
        return true;
    }

    // Main method
    public static void main(String[] args) {
        IfPalindromeBrute list = new IfPalindromeBrute();

        // Create nodes
        Node head = list.new Node(1);
        head.next = list.new Node(3);
        head.next.next = list.new Node(2);
        head.next.next.next = list.new Node(1);

        // Check palindrome
        boolean result = list.ifPalindrome(head);
        System.out.println("Is Palindrome? " + result);
    }
}
