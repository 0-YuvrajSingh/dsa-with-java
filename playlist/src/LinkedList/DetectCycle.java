package LinkedList;

public class DetectCycle {

    // Definition for singly-linked list
    static class ListNode {
        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
            this.next = null;
        }
    }

    // Function to detect cycle
    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) return false;

        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;          // move 1 step
            fast = fast.next.next;     // move 2 steps

            if (slow == fast) {
                return true; // cycle detected
            }
        }
        return false; // no cycle
    }

    // Test the implementation
    public static void main(String[] args) {
        DetectCycle obj = new DetectCycle();

        // create nodes
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);

        // create a cycle: last node points to second node
        head.next.next.next.next = head.next;

        // check for cycle
        boolean result = obj.hasCycle(head);
        System.out.println("Cycle present? " + result); // should print true
    }
}
