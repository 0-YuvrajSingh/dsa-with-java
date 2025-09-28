package LinkedList.SingleLinkedList;

public class Reverse {
    public static class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public static Node reverse(Node head) {
        Node curr = head;
        Node prev = null;
        Node temp;

        while (curr != null) {
            temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }
        return prev;
    }

    public static Node recursiveReverse(Node curr, Node prev) {
        if (curr == null) {
            return prev; // when curr is null, prev is new head
        }

        Node temp = curr.next;  // save next
        curr.next = prev;       // reverse link
        prev = curr;            // advance prev
        return recursiveReverse(temp, prev); // recurse forward
    }


    public static void main(String[] args) {
        // create linked list: 1 -> 2 -> 3 -> 4
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);

        System.out.println("Original list:");
        printList(head);

        // reverse iteratively
        head = reverse(head);
        System.out.println("Reversed list (iterative):");
        printList(head);

        // reverse back recursively
        head = recursiveReverse(head, null);
        System.out.println("Reversed list again (recursive):");
        printList(head);
    }


    // helper method to print linked list
    public static void printList(Node head) {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }
}
