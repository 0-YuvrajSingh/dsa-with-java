package LinkedList.Problems;

public class AddOneAtLast {
    public class Node {
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
        while (curr != null) {
            Node temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }
        return prev;
    }

    public Node addOneAtLast(Node head) {
        if (head == null) return new Node(1);

        head = reverse(head);
        Node curr = head;
        int carry = 1;

        while (curr != null) {
            int sum = curr.data + carry;
            curr.data = sum % 10;
            carry = sum / 10;

            if (carry == 0) break;

            if (curr.next == null && carry > 0) {
                curr.next = new Node(carry);
                carry = 0;
            }
            curr = curr.next;
        }

        return reverse(head);
    }

    public void printList(Node head) {
        Node curr = head;
        while (curr != null) {
            System.out.print(curr.data + " ");
            curr = curr.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        AddOneAtLast list = new AddOneAtLast();

        Node head = list.new Node(9);
        head.next = list.new Node(9);
        head.next.next = list.new Node(9);

        System.out.print("Original: ");
        list.printList(head);

        head = list.addOneAtLast(head);

        System.out.print("After +1: ");
        list.printList(head);
    }
}
