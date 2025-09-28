package LinkedList;

public class SortLinkedListOptimal {
    public static class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public Node mergeSortLinkedList(Node head) {
        if (head == null || head.next == null) {
            return head;
        }
        Node middle = findMiddle(head);

        Node leftHead = head;
        Node rightHead = middle.next;

        middle.next = null;

        leftHead = mergeSortLinkedList(leftHead);
        rightHead = mergeSortLinkedList(rightHead);

        return mergeLinkedList(leftHead, rightHead);
    }

    private Node mergeLinkedList(Node leftHead, Node rightHead) {
        Node dummyNode = new Node(-1);
        Node curr = dummyNode;
        while (leftHead != null && rightHead != null) {
            if (leftHead.data <= rightHead.data) {
                curr.next = leftHead;
                leftHead = leftHead.next;
            } else {
                curr.next = rightHead;
                rightHead = rightHead.next;
            }
            curr = curr.next;
        }
        if (leftHead != null) {
            curr.next = leftHead;
        } else {
            curr.next = rightHead;
        }
        return dummyNode.next;
    }

    public Node findMiddle(Node head) {
        Node slow = head;
        Node fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public void printList(Node head) {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        SortLinkedListOptimal obj = new SortLinkedListOptimal();

        // Create unsorted linked list: 4 -> 2 -> 1 -> 3 -> null
        Node head = new Node(4);
        head.next = new Node(2);
        head.next.next = new Node(1);
        head.next.next.next = new Node(3);

        System.out.println("Before Sorting:");
        obj.printList(head);

        // Sort using Merge Sort
        head = obj.mergeSortLinkedList(head);

        System.out.println("After Sorting:");
        obj.printList(head);
    }
}
