package LinkedList;

public class ReverseLLSizeK {
    public static class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public Node reverseInSizeK(Node head, int k) {
        if (head == null || k <= 1) return head;

        Node temp = head;
        Node prev = null;

        while (temp != null) {
            Node kth = findKth(temp, k);
            if (kth == null) {
                break; // not enough nodes left
            }

            Node nextNode = kth.next;
            kth.next = null;

            Node newHead = reverse(temp);

            if (prev == null) {
                head = newHead; // first group becomes new head
            } else {
                prev.next = newHead;
            }

            prev = temp; // temp becomes last node after reversal
            temp = nextNode;
        }
        return head;
    }

    private Node findKth(Node head, int k) {
        Node temp = head;
        while (temp != null && k > 1) {
            temp = temp.next;
            k--;
        }
        return temp;
    }

    private Node reverse(Node head) {
        Node curr = head;
        Node prev = null;
        while (curr != null) {
            Node next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }

    // 🔹 Utility function to print linked list
    private void printList(Node head) {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    // 🔹 Main method for testing
    public static void main(String[] args) {
        ReverseLLSizeK list = new ReverseLLSizeK();

        // Create linked list: 1 -> 2 -> 3 -> 4 -> 5 -> 6 -> 7 -> 8 -> 9
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);
        head.next.next.next.next.next = new Node(6);
        head.next.next.next.next.next.next = new Node(7);
        head.next.next.next.next.next.next.next = new Node(8);
        head.next.next.next.next.next.next.next.next = new Node(9);

        System.out.println("Original List:");
        list.printList(head);

        int k = 3; // group size
        head = list.reverseInSizeK(head, k);

        System.out.println("Reversed in groups of " + k + ":");
        list.printList(head);
    }
}
