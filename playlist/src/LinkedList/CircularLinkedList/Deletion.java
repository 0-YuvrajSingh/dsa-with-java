package LinkedList.CircularLinkedList;

public class Deletion {

    private Node head;
    private Node tail;

    // Constructor for an empty circular linked list
    public Deletion() {
        this.head = null;
        this.tail = null;
    }

    // Helper: insert at end (for creating initial list to test deletion)
    public void insertAtEnd(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            tail = newNode;
            newNode.next = head;
            return;
        }
        tail.next = newNode;
        newNode.next = head;
        tail = newNode;
    }

    // Delete the first node
    public void deleteAtBeginning() {
        if (head == null) {
            System.out.println("List is empty.");
            return;
        }
        if (head == tail) { // only one node
            head = null;
            tail = null;
            return;
        }
        head = head.next;
        tail.next = head;
    }

    // Delete the last node
    public void deleteAtEnd() {
        if (head == null) {
            System.out.println("List is empty.");
            return;
        }
        if (head == tail) { // only one node
            head = null;
            tail = null;
            return;
        }

        Node current = head;
        while (current.next != tail) { // reach second last
            current = current.next;
        }
        current.next = head;
        tail = current;
    }

    // Delete a node by value
    public void deleteByValue(int data) {
        if (head == null) {
            System.out.println("List is empty.");
            return;
        }
        if (head.data == data) {
            deleteAtBeginning();
            return;
        }

        Node current = head;
        Node nextNode;
        do {
            nextNode = current.next;
            if (nextNode.data == data) {
                current.next = nextNode.next;
                if (nextNode == tail) {
                    tail = current;
                }
                return;
            }
            current = current.next;
        } while (current != head);

        System.out.println("Value not found: " + data);
    }

    // Display the circular linked list
    public void display() {
        if (head == null) {
            System.out.println("List is empty.");
            return;
        }
        Node temp = head;
        do {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        } while (temp != head);
        System.out.println("(back to head)");
    }

    // Main method to test Deletion operations
    public static void main(String[] args) {
        Deletion cll = new Deletion();

        // Create list: 10 -> 20 -> 30 -> 40 -> back to head
        cll.insertAtEnd(10);
        cll.insertAtEnd(20);
        cll.insertAtEnd(30);
        cll.insertAtEnd(40);

        System.out.println("Original Circular Linked List:");
        cll.display();

        System.out.println("\nDeleting from beginning...");
        cll.deleteAtBeginning();
        cll.display();

        System.out.println("\nDeleting from end...");
        cll.deleteAtEnd();
        cll.display();

        System.out.println("\nDeleting by value (30)...");
        cll.deleteByValue(30);
        cll.display();
    }

    // Node class (inner class)
    private class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }
}
