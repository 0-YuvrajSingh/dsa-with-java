package LinkedList.Problems;

public class IfPalindromeOptimal {
    public class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public Node reverse(Node head) {
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

    public boolean ifPalindrome(Node head) {
        if (head == null || head.next == null) return true;

        Node slow = head;
        Node fast = head;

        //fast.next.next for the first middle for even length
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        Node newNode = reverse(slow.next);
        Node first = head;
        Node second = newNode;
        while (second != null) {
            if (first.data != second.data) {
                reverse(newNode);
                return false;
            }
            first = first.next;
            second = second.next;
        }
        slow.next = reverse(newNode);
        return true;
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
        IfPalindromeOptimal list = new IfPalindromeOptimal();

        // Create palindrome list: 1 -> 2 -> 2 -> 1
        Node head1 = list.new Node(1);
        head1.next = list.new Node(2);
        head1.next.next = list.new Node(2);
        head1.next.next.next = list.new Node(1);

        System.out.print("List 1: ");
        list.printList(head1);
        System.out.println("Is Palindrome? " + list.ifPalindrome(head1));

        // Create non-palindrome list: 1 -> 2 -> 3
        Node head2 = list.new Node(1);
        head2.next = list.new Node(2);
        head2.next.next = list.new Node(3);

        System.out.print("List 2: ");
        list.printList(head2);
        System.out.println("Is Palindrome? " + list.ifPalindrome(head2));
    }
}
