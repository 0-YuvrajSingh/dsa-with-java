package LinkedList.Problems;

public class LLIntersectionBetter {
    public static class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public static Node collisionPoint(Node small, Node large, int diff) {
        while(diff > 0) {
            diff--;
            large = large.next;
        }
        while (small != large) {
            small = small.next;
            large = large.next;
        }
        return small;
    }

    public static int findLength(Node head) {
        Node temp = head;
        int length = 0;
        while (temp != null){
            length++;
            temp = temp.next;
        }
        return length;
    }

    public static void main(String[] args) {
        Node head1 = new Node(5);
        head1.next = new Node(6);
        head1.next.next = new Node(7);

        Node common1 = new Node(8);
        common1.next = new Node(9);
        common1.next.next = new Node(10);

        head1.next.next.next = common1;

        Node head2 = new Node(7);
        head2.next = common1;

        int n1 = findLength(head1);
        int n2 = findLength(head2);

        Node collision;
        if (n1 > n2) {
            collision = collisionPoint(head2, head1, n1 - n2);
        } else {
            collision = collisionPoint(head1, head2, n2 - n1);
        }

        if (collision != null) {
            System.out.println("Collision at node with data: " + collision.data);
        } else {
            System.out.println("No intersection found.");
        }
    }

}
