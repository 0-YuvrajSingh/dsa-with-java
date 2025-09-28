package LinkedList.DoubleLinkedList;

public class Reverse {
    public static class Node {
        int data;
        Node next;
        Node prev;

        Node(int data) {
            this.data = data;
        }
    }

    // Reverse function
    public static Node reverse(Node head) {
        Node curr = head;
        Node temp = null;

        while (curr != null) {
            temp = curr.prev;
            curr.prev = curr.next;
            curr.next = temp;
            curr = curr.prev;
        }

        if (temp != null) {
            head = temp.prev; // new head
        }

        return head;
    }

    // Print function
    public static void printList(Node head) {
        Node curr = head;
        while (curr != null) {
            System.out.print(curr.data + " ");
            curr = curr.next;
        }
        System.out.println();
    }

    
    public static void main(String[] args) {
        // Create DLL: 1 <-> 2 <-> 3 <-> 4
        Node head = new Node(1);
        Node second = new Node(2);
        Node third = new Node(3);
        Node fourth = new Node(4);

        head.next = second;
        second.prev = head;
        second.next = third;
        third.prev = second;
        third.next = fourth;
        fourth.prev = third;

        System.out.println("Original list:");
        printList(head);

        head = reverse(head);

        System.out.println("Reversed list:");
        printList(head);
    }
}
