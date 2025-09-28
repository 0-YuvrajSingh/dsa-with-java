package LinkedList.SingleLinkedList;

public class Insertion {

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
        Node head = null;

        System.out.println("Insertion in Linked List:");
        head = insertAtBeginning(head, 10);
        head = insertAtEnd(head, 20);
        head = insertAtEnd(head, 30);
        head = insertAtPosition(head, 25, 3);

        print(head);
    }

    // Insert at beginning
    public static Node insertAtBeginning(Node head, int data) {
        Node newNode = new Node(data);
        newNode.next = head;
        return newNode;
    }

    // Insert at end
    public static Node insertAtEnd(Node head, int data) {
        Node newNode = new Node(data);
        if (head == null) {
            return newNode;
        }
        Node temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = newNode;
        return head;
    }

    // Insert at a given position (1-based)
    public static Node insertAtPosition(Node head, int data, int position) {
        Node newNode = new Node(data);
        if (position <= 1 || head == null) {
            newNode.next = head;
            return newNode;
        }

        Node temp = head;
        for (int i = 1; temp != null && i < position - 1; i++) {
            temp = temp.next;
        }

        if (temp == null) {
            return head; // position out of range
        }

        newNode.next = temp.next;
        temp.next = newNode;
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
