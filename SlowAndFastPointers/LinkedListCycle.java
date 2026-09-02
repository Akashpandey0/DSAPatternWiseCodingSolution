// Given head, the head of a linked list, determine if the linked list has a cycle in it.
// There is a cycle in a linked list if there is some node in the list that can be reached again by continuously
// following the next pointer. Internally, pos is used to denote the index of the node that tail's next pointer is
// connected to. Note that pos is not passed as a parameter.
// Return true if there is a cycle in the linked list. Otherwise, return false.

// Example 1:

// Input: head = [3,2,0,-4], pos = 1
// Output: true
// Explanation: There is a cycle in the linked list, where the tail connects to the 1st node (0-indexed).
// Example 2:

// Input: head = [1,2], pos = 0
// Output: true
// Explanation: There is a cycle in the linked list, where the tail connects to the 0th node.
// Example 3:

// Input: head = [1], pos = -1
// Output: false
// Explanation: There is no cycle in the linked list.

// Constraints:
// The number of the nodes in the list is in the range [0, 104].
// -105 <= Node.val <= 105
// pos is -1 or a valid index in the linked-list

package SlowAndFastPointers;

public class LinkedListCycle {

    static class ListNode {
        int val;
        ListNode next;
        ListNode(int val) { this.val = val; }
    }

    // Floyd's Cycle Detection: slow moves 1 step, fast moves 2 steps
    // If they meet, there's a cycle. If fast reaches null, no cycle.
    // Time: O(n) | Space: O(1)
    public static boolean hasCycle(ListNode head) {
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) return true;
        }
        return false;
    }

    public static void main(String[] args) {
        // Example 1: [3,2,0,-4], pos=1 → true
        ListNode head1 = new ListNode(3);
        head1.next = new ListNode(2);
        head1.next.next = new ListNode(0);
        head1.next.next.next = new ListNode(-4);
        head1.next.next.next.next = head1.next; // cycle at index 1
        System.out.println(hasCycle(head1)); // true

        // Example 2: [1,2], pos=0 → true
        ListNode head2 = new ListNode(1);
        head2.next = new ListNode(2);
        head2.next.next = head2; // cycle at index 0
        System.out.println(hasCycle(head2)); // true

        // Example 3: [1], pos=-1 → false
        ListNode head3 = new ListNode(1);
        System.out.println(hasCycle(head3)); // false
    }
}
