// Given the head of a linked list, reverse the nodes of the list k at a time, and return the modified list.
// k is a positive integer and is less than or equal to the length of the linked list. If the number of nodes is not a multiple of k then left-out nodes, in the end, should remain as it is.
// You may not alter the values in the list's nodes, only nodes themselves may be changed.

// Example 1:
// Input: head = [1,2,3,4,5], k = 2
// Output: [2,1,4,3,5]

// Example 2:
// Input: head = [1,2,3,4,5], k = 3
// Output: [3,2,1,4,5]

// Constraints:
// The number of nodes in the list is n.
// 1 <= k <= n <= 5000
// 0 <= Node.val <= 1000

package LinkedList;
public class ReverseNodesinKGroups {
    static class ListNode {
        int value;
        ListNode next;

        public ListNode(int value) {
            this.value = value;
            this.next = null;
        }
    }

    public static ListNode reverseKGroup(ListNode head, int k) {
        if(head == null || k == 1) return head;

        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode prevGroup = dummy;

        while(true) {
            ListNode kthNode = getKthNode(prevGroup, k);
            if(kthNode == null) break;

            ListNode nextGroup = kthNode.next;

            // reversing the List
            ListNode curr = prevGroup.next;
            ListNode prev = nextGroup;

            while(curr != nextGroup) {
                ListNode nextNode = curr.next;
                curr.next = prev;
                prev = curr;
                curr = nextNode;
            }

            // connecting the previous group to the new group
            ListNode nextPrevGroup = prevGroup.next;
            prevGroup.next = kthNode;
            prevGroup = nextPrevGroup;
        }

        return dummy.next;
    }

    private static ListNode getKthNode(ListNode curr, int k) {
        while(curr != null && k > 0) {
            curr = curr.next;
            k--;
        }
        return curr;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        ListNode result = reverseKGroup(head, 2);
        while(result != null) {
            System.out.print(result.value + " ");
            result = result.next;
        }
    }
}
