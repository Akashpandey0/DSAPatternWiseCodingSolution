/*Given a linked list, swap every two adjacent nodes and return its head. You must solve the problem without modifying the values in the list's nodes (i.e., only nodes themselves may be changed.)

Example 1:
Input: head = [1,2,3,4]
Output: [2,1,4,3]

Example 2:
Input: head = []
Output: []

Example 3:
nput: head = [1]
Output: [1]

Example 4:
Input: head = [1,2,3]
Output: [2,1,3]

Constraints:
The number of nodes in the list is in the range [0, 100].
0 <= Node.val <= 100 */

package LinkedList;

public class SwapPairs {
    static class ListNode {
        int value;
        ListNode next;
        public ListNode(int value) {
            this.value = value;
            this.next = null;
        }
    }

    public static ListNode swapNodesPairs(ListNode head) {
        if(head == null) return head;

        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode prev = dummy;

        while(prev.next != null && prev.next.next != null) {
            ListNode first = prev.next;
            ListNode second = prev.next.next;

            first.next = second.next;
            second.next = first;
            prev.next = second;


            prev = first;
        }

        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode head1 = new ListNode(1);
        head1.next = new ListNode(2);
        head1.next.next = new ListNode(3);
        head1.next.next.next = new ListNode(4);

        ListNode swapPairs = swapNodesPairs(head1);
        while(swapPairs != null) {
            System.out.print(swapPairs.value + " ");
            swapPairs = swapPairs.next;
        }
    }
}
