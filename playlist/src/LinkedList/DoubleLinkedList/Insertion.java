package LinkedList.DoubleLinkedList;

public class Insertion {

    public static class Node {
        int data;
        Node next;
        Node prev;

        Node(int data) {
            this.data = data;
            this.prev = null;
            this.next = null;
        }
    }

    public static Node insertBeginning(Node head, int data) {
        Node newNode = new Node(data);
        newNode.next = head;
        if (head != null) {
            head.prev = newNode;
        }
        return newNode; // new node becomes head
    }

    public static Node insertEnd(Node head, int data) {
        Node newNode = new Node(data);

        if (head == null) {
            return newNode; // list was empty
        }
        Node curr = head;
        while (curr.next != null) { // go to last node
            curr = curr.next;
        }
        curr.next = newNode;
        newNode.prev = curr;
        return head;
    }

    public static Node insertPosition(Node head, int position, int data) {
        Node newNode = new Node(data);

        if (position <= 0) {
            System.out.println("Invalid Position");
            return head;
        }

        if (position == 1) { // insert at beginning
            newNode.next = head;
            if (head != null) {
                head.prev = newNode;
            }
            return newNode;
        }

        Node curr = head;
        for (int i = 1; i < position - 1 && curr != null; ++i) {
            curr = curr.next;
        }

        if (curr == null) { // position out of range
            System.out.println("Invalid Position");
            return head;
        }

        newNode.next = curr.next;
        newNode.prev = curr;
        if (curr.next != null) {
            curr.next.prev = newNode;
        }
        curr.next = newNode;
        return head;
    }

    public static void printForward(Node head) {
        Node curr = head;
        while (curr != null) {
            System.out.print(curr.data + " <-> ");
            curr = curr.next;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        Node head = null;

        // Insert at beginning
        head = insertBeginning(head, 20);
        head = insertBeginning(head, 10);

        // Insert at end
        head = insertEnd(head, 30);
        head = insertEnd(head, 40);

        System.out.println("Forward after beginning & end insertions:");
        printForward(head);

        // Insert at position (1-based index)
        head = insertPosition(head, 3, 25); // Insert 25 at position 3

        System.out.println("Forward after inserting at position 3:");
        printForward(head);
    }
}
