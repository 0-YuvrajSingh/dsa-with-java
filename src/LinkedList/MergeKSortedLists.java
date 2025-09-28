package LinkedList;

// Definition for singly-linked list
class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

public class MergeKSortedLists {

    public static void main(String[] args) {
        // Example: merge 3 sorted linked lists
        ListNode l1 = new ListNode(1, new ListNode(4, new ListNode(5)));
        ListNode l2 = new ListNode(1, new ListNode(3, new ListNode(4)));
        ListNode l3 = new ListNode(2, new ListNode(6));

        ListNode[] lists = {l1, l2, l3};

        Solution solution = new Solution();
        ListNode merged = solution.mergeKLists(lists);

        // Print merged list
        printList(merged); // Expected: 1 -> 1 -> 2 -> 3 -> 4 -> 4 -> 5 -> 6
    }

    // Helper to print linked list
    private static void printList(ListNode head) {
        ListNode curr = head;
        while (curr != null) {
            System.out.print(curr.val);
            if (curr.next != null) System.out.print(" -> ");
            curr = curr.next;
        }
        System.out.println();
    }

    // Solution class implementing Divide & Conquer
    static class Solution {
        public ListNode mergeKLists(ListNode[] lists) {
            if (lists == null || lists.length == 0) return null;
            int n = lists.length;
            int interval = 1;

            while (interval < n) {
                for (int i = 0; i + interval < n; i += interval * 2) {
                    lists[i] = merge(lists[i], lists[i + interval]);
                }
                interval *= 2;
            }
            return lists[0];
        }

        private ListNode merge(ListNode l1, ListNode l2) {
            ListNode dummy = new ListNode(-1);
            ListNode curr = dummy;

            while (l1 != null && l2 != null) {
                if (l1.val <= l2.val) {
                    curr.next = l1;
                    l1 = l1.next;
                } else {
                    curr.next = l2;
                    l2 = l2.next;
                }
                curr = curr.next;
            }

            if (l1 != null) curr.next = l1;
            if (l2 != null) curr.next = l2;

            return dummy.next;
        }
    }
}
