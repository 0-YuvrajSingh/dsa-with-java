package LinkedList;

public class RotateLinkedList {
    public static class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public Node rotateRight(Node head, int k) {
        if (head == null || head.next == null || k == 0) return head;

        // Step 1: find length
        int len = 1;
        Node tail = head;
        while (tail.next != null) {
            len++;
            tail = tail.next;
        }

        // Step 2: mod
        k = k % len;
        if (k == 0) return head;

        // Step 3: connect tail to head (circular)
        tail.next = head;

        // Step 4: find new tail (len - k)
        Node lastNode = findLastNode(head, len - k);

        // Step 5: break link
        head = lastNode.next;
        lastNode.next = null;

        return head;
    }

    private Node findLastNode(Node head, int k) {
        Node temp = head;
        for (int i = 1; i < k; i++) {
            temp = temp.next;
        }
        return temp;
    }

    // ---------- Test Main ----------
    public static void main(String[] args) {
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);

        RotateLinkedList solver = new RotateLinkedList();
        head = solver.rotateRight(head, 2);

        Node curr = head;
        while (curr != null) {
            System.out.print(curr.data + (curr.next != null ? " -> " : ""));
            curr = curr.next;
        }
    }
}
