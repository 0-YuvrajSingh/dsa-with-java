package LinkedList;

public class LinkedListFlatteningOptimal {
    public static class Node {
        int data;
        Node next;
        Node child;

        public Node(int data) {
            this.data = data;
            this.next = null;
            this.child = null;
        }
    }

    public Node flattenedLinkedList(Node head) {
        // base case
        if (head == null || head.next == null) return head;

        // recursively flatten the rest
        head.next = flattenedLinkedList(head.next);

        // merge current list (head) with next flattened list
        head = merge(head, head.next);

        return head;
    }

    public Node merge(Node l1, Node l2) {
        Node dummyNode = new Node(-1);
        Node curr = dummyNode;

        while (l1 != null && l2 != null) {
            if (l1.data <= l2.data) {
                curr.child = l1;
                l1 = l1.child;
            } else {
                curr.child = l2;
                l2 = l2.child;
            }
            curr = curr.child;
            curr.next = null; // break unwanted next links
        }

        if (l1 != null) curr.child = l1;
        else curr.child = l2;

        return dummyNode.child;
    }

    // ----------- Test Main Method -----------
    public static void main(String[] args) {
        LinkedListFlatteningOptimal solver = new LinkedListFlatteningOptimal();

        // Build a sample list:
        // 5 -> 10 -> 19 -> 28
        Node head = new Node(5);
        head.next = new Node(10);
        head.next.next = new Node(19);
        head.next.next.next = new Node(28);

        // Children
        head.child = new Node(7);
        head.child.child = new Node(8);
        head.child.child.child = new Node(30);

        head.next.child = new Node(20);

        head.next.next.child = new Node(22);
        head.next.next.child.child = new Node(50);

        head.next.next.next.child = new Node(35);
        head.next.next.next.child.child = new Node(40);
        head.next.next.next.child.child.child = new Node(45);

        // Flatten
        Node flattened = solver.flattenedLinkedList(head);

        // Print flattened list
        System.out.print("Flattened Linked List: ");
        Node curr = flattened;
        while (curr != null) {
            System.out.print(curr.data);
            if (curr.child != null) System.out.print(" -> ");
            curr = curr.child;
        }
        System.out.println();
    }
}
