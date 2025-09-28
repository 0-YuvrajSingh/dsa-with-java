package LinkedList.Problems;

import java.util.ArrayList;
import java.util.Collections;

public class FlatteningALinkedListBrute {
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

    public Node flatteningALinkedList(Node head) {
        ArrayList<Integer> list = new ArrayList<>();
        Node temp = head;
        while(temp != null){
            Node curr = temp;
            while (curr != null) {
                list.add(curr.data);
                curr = curr.child;
            }
            temp = temp.next;
        }
        Collections.sort(list);
        return convertToFlattenedLinkedList(list);
    }

    private Node convertToFlattenedLinkedList(ArrayList<Integer> list) {
        Node dummyNode = new Node(-1);
        Node temp = dummyNode;
        for (int i = 0; i < list.size(); i++) {
            temp.child = new Node(list.get(i));
            temp = temp.child;
        }
        return dummyNode.child;
    }

    // --- psvm to test the method ---
    public static void main(String[] args) {
        FlatteningALinkedListBrute solver = new FlatteningALinkedListBrute();

        // build test list:
        // Level 0: 5 -> 10 -> 19 -> 28
        Node head = new Node(5);
        head.next = new Node(10);
        head.next.next = new Node(19);
        head.next.next.next = new Node(28);

        // children:
        head.child = new Node(7);
        head.child.child = new Node(8);
        head.child.child.child = new Node(30);

        head.next.child = new Node(20);

        head.next.next.child = new Node(22);
        head.next.next.child.child = new Node(50);

        head.next.next.next.child = new Node(35);
        head.next.next.next.child.child = new Node(40);
        head.next.next.next.child.child.child = new Node(45);

        // flatten & print
        Node flattened = solver.flatteningALinkedList(head);

        System.out.print("Flattened list (via child pointers): ");
        Node curr = flattened;
        while (curr != null) {
            System.out.print(curr.data);
            if (curr.child != null) System.out.print(" -> ");
            curr = curr.child;
        }
        System.out.println();
    }
}