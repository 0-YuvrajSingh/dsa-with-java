package LinkedList.Problems;

public class TwoSum {
    public static class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public static Node twoSum(Node l1, Node l2) {
        Node dummy = new Node(0);  // dummy head
        Node curr = dummy;
        int carry = 0;

        while (l1 != null || l2 != null || carry != 0) {
            int val1 = (l1 != null) ? l1.data : 0;
            int val2 = (l2 != null) ? l2.data : 0;

            int sum = val1 + val2 + carry;
            carry = sum / 10;

            curr.next = new Node(sum % 10);
            curr = curr.next;

            if (l1 != null) l1 = l1.next;
            if (l2 != null) l2 = l2.next;
        }

        return dummy.next; // skip dummy and return result head
    }

    public static void printList(Node head) {
        Node curr = head;
        while (curr != null) {
            System.out.print(curr.data + " ");
            curr = curr.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        // Number1: 342 -> (2 -> 4 -> 3)
        Node l1 = new Node(2);
        l1.next = new Node(4);
        l1.next.next = new Node(3);

        // Number2: 465 -> (5 -> 6 -> 4)
        Node l2 = new Node(5);
        l2.next = new Node(6);
        l2.next.next = new Node(4);

        Node result = twoSum(l1, l2); // Expected: 807 -> (7 -> 0 -> 8)

        printList(result); // Output: 7 0 8
    }
}
