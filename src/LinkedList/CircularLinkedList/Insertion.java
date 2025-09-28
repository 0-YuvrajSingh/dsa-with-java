package LinkedList.CircularLinkedList;

public class Insertion {

    private Node head;
    private Node tail;

    public Insertion() {
        this.head = null;
        this.tail = null;
    }

    // Insert at the beginning
    public void insertAtBeginning(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            tail = newNode;
            newNode.next = head; // circular link
            return;
        }
        newNode.next = head;
        tail.next = newNode;
        head = newNode;
    }

    // Insert at the end
    public void insertAtEnd(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            tail = newNode;
            newNode.next = head; // circular link
            return;
        }
        tail.next = newNode;
        newNode.next = head;
        tail = newNode;
    }

    // Display the circular linked list
    public void display() {
        if (head == null) {
            System.out.println("List is empty.");
            return;
        }
        Node curr = head;
        do {
            System.out.print(curr.data + " -> ");
            curr = curr.next;
        } while (curr != head);
        System.out.println("(back to head)");
    }

    // Main method for testing
    public static void main(String[] args) {
        Insertion circularLinkedList = new Insertion();

        circularLinkedList.insertAtEnd(10);
        circularLinkedList.insertAtEnd(20);
        circularLinkedList.insertAtEnd(30);
        circularLinkedList.display();

        circularLinkedList.insertAtBeginning(5);
        circularLinkedList.display();

        circularLinkedList.insertAtEnd(40);
        circularLinkedList.display();
    }

    // Inner Node class
    private static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
        }
    }
}
