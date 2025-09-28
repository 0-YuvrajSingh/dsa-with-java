package LinkedList.SingleLinkedList;

public class Deletion {

    // Node class for singly linked list
    public static class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public static void main(String[] args) {
        // Create linked list: 2 -> 3 -> 5 -> 6 -> null
        Node head = new Node(2);
        head.next = new Node(3);
        head.next.next = new Node(5);
        head.next.next.next = new Node(6);

        System.out.println("Original Linked List:");
        print(head);

        // Delete first node
        head = deleteBeginning(head);
        System.out.println("After deleting first node:");
        print(head);

        // Delete last node
        head = deleteEnd(head);
        System.out.println("After deleting last node:");
        print(head);

        // Delete node at position 2
        head = deletePosition(head, 2);
        System.out.println("After deleting node at position 2:");
        print(head);
    }

    // Delete first node
    public static Node deleteBeginning(Node head) {
        if (head == null) {
            return null;
        }
        return head.next;
    }

    // Delete last node
    public static Node deleteEnd(Node head) {
        if (head == null) {
            return null;
        }
        if (head.next == null) {
            return null;
        }

        Node temp = head;
        while (temp.next.next != null) {
            temp = temp.next;
        }
        temp.next = null;
        return head;
    }

    // Delete node at a given position (1-based)
    public static Node deletePosition(Node head, int position) {
        if (head == null || position <= 0) {
            return head;
        }

        if (position == 1) {
            return head.next;
        }

        Node temp = head;
        Node prev = null;
        for (int i = 1; temp != null && i < position; i++) {
            prev = temp;
            temp = temp.next;
        }

        if (temp == null) {
            return head;
        }

        prev.next = temp.next;
        return head;
    }

    // Print linked list
    public static void print(Node head) {
        Node curr = head;
        while (curr != null) {
            System.out.print(curr.data + " -> ");
            curr = curr.next;
        }
        System.out.println("null");
    }
}
