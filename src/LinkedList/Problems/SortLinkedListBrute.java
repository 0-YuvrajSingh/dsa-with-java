package LinkedList.Problems;

import java.util.ArrayList;
import java.util.Collections;

public class SortLinkedListBrute {
    public static class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public Node sortLinkedList(Node head) {
        ArrayList<Integer> list = new ArrayList<>();
        Node temp = head;
        while (temp != null) {
            list.add(temp.data);
            temp = temp.next;
        }
        Collections.sort(list);
        Node curr = head;
        for (int i = 0; i < list.size(); i++) {
            curr.data = list.get(i);
            curr = curr.next;
        }
        return head;
    }

    // 🔹 Helper function to print a linked list
    public void printList(Node head) {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        SortLinkedListBrute listObj = new SortLinkedListBrute();

        // Create a sample linked list: 4 -> 2 -> 1 -> 3 -> null
        Node head = new Node(4);
        head.next = new Node(2);
        head.next.next = new Node(1);
        head.next.next.next = new Node(3);

        System.out.println("Before Sorting:");
        listObj.printList(head);

        // Sort the linked list
        head = listObj.sortLinkedList(head);

        System.out.println("After Sorting:");
        listObj.printList(head);
    }
}
