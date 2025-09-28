package LinkedList.Problems;

import java.util.HashMap;
public class LLIntersectionBrute {
    public class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public boolean ifIntersected(Node head1, Node head2) {
        HashMap<Node, Integer> freq = new HashMap<>();
        Node temp = head1;
        while(temp != null) {
            int value = freq.getOrDefault(temp, 0);
            freq.put(temp, value+1);
            temp = temp.next;
        }
        temp = head2;
        while (temp != null) {
            if(freq.containsKey(temp)) {
                return true;
            }
            temp = temp.next;
        }
        return false;
    }

    public static void main(String[] args) {
        LLIntersectionBrute list = new LLIntersectionBrute();

        // Create first list: 1 -> 2 -> 3
        Node head1 = list.new Node(1);
        head1.next = list.new Node(2);
        Node common = list.new Node(3);
        head1.next.next = common;

        // Create second list: 4 -> 5 -> 3 (intersects at 3)
        Node head2 = list.new Node(4);
        head2.next = list.new Node(5);
        head2.next.next = common; // intersection here

        System.out.println("Lists intersect? " + list.ifIntersected(head1, head2));

        // Create third list: 6 -> 7 (no intersection)
        Node head3 = list.new Node(6);
        head3.next = list.new Node(7);
        head3.next.next = common;

        System.out.println("List1 and List3 intersect? " + list.ifIntersected(head1, head3));
    }
}
