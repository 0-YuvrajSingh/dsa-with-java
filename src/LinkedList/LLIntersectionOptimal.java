package LinkedList;

public class LLIntersectionOptimal {
    public static class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public Node collisionPoint(Node head1, Node head2) {
        if (head1 == null || head2 == null) return null;

        Node t1 = head1;
        Node t2 = head2;

        while (t1 != t2) {
            t1 = t1.next;
            t2 = t2.next;

            if(t1 == t2) return t1;

            if(t1 == null) t1= head2;
            if(t2 == null) t2 = head1;
        }
        return t1; // either intersection node or null
    }

    public static void main(String[] args) {
        LLIntersectionOptimal list = new LLIntersectionOptimal();

        // Create first list: 1 -> 2 -> 3
        Node head1 = new Node(1);
        head1.next = new Node(2);
        Node common = new Node(3);
        head1.next.next = common;
        common.next = new Node(4);
        common.next.next = new Node(5);

        // Create second list: 9 -> 3 (intersects at 3)
        Node head2 = new Node(9);
        head2.next = common;

        Node result = list.collisionPoint(head1, head2);
        if (result != null) {
            System.out.println("Lists intersect at node with data: " + result.data);
        } else {
            System.out.println("No intersection found.");
        }

        // Another case: no intersection
        Node head3 = new Node(6);
        head3.next = new Node(7);

        Node result2 = list.collisionPoint(head1, head3);
        if (result2 != null) {
            System.out.println("List1 and List3 intersect at node with data: " + result2.data);
        } else {
            System.out.println("List1 and List3 do not intersect.");
        }
    }
}
