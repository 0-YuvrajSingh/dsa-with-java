package LinkedList.DoubleLinkedList;

public class Deletion {

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

    public static Node deleteBeginning(Node head) {
        if (head == null) {
            return null;
        }
        Node temp = head;
        head = head.next;
        if (head != null) {
            head.prev = null;
        }
        temp = null;
        return head;
    }

    public static Node deleteEnd(Node head) {
        if (head == null) {
            return null;
        }
        if (head.next == null) {
            return null;
        }

        Node curr = head;
        while (curr.next != null) {
            curr = curr.next;
        }

        curr.prev.next = null;
        curr = null;
        return head;
    }

    public static Node deletePosition(Node head, int position) {
        if (head == null || position <= 0) {
            return head;
        }

        if (position == 1) {
            return deleteBeginning(head);
        }

        Node curr = head;
        for (int i = 1; i < position && curr != null; i++) {
            curr = curr.next;
        }

        if (curr == null) {
            return head;
        }

        if (curr.next != null) {
            curr.next.prev = curr.prev;
        }

        if (curr.prev != null) {
            curr.prev.next = curr.next;
        }

        curr = null;
        return head;
    }

    public static void printForward(Node head) {
        Node curr = head;
        System.out.print("Null <-> ");
        while (curr != null) {
            System.out.print(curr.data);
            if (curr.next != null) {
                System.out.print(" <-> ");
            }
            curr = curr.next;
        }
        System.out.println(" <-> Null");
    }

    public static void main(String[] args) {
        Node head = new Node(10);
        Node second = new Node(20);
        Node third = new Node(30);
        Node fourth = new Node(40);

        head.next = second;
        second.prev = head;
        second.next = third;
        third.prev = second;
        third.next = fourth;
        fourth.prev = third;

        printForward(head);

        head = deleteBeginning(head);
        printForward(head);

        head = deleteEnd(head);
        printForward(head);

        head = deletePosition(head, 2);
        printForward(head);
    }
}
