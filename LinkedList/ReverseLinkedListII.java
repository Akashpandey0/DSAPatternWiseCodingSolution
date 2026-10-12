/*
Given the head of a singly linked list and two integers left and right where left <= right, reverse the nodes of the list from position left to position right, and return the reversed list.

Example 1:
Input: head = [10,20,30,40,50], left = 2, right = 4
Output: [10,40,30,20,50]

Example 2:
Input: head = [5], left = 1, right = 1
Output: [5]

Constraints:

The number of nodes in the list is n.
1 <= n <= 500
-500 <= Node.val <= 500
1 <= left <= right <= n
 */

package LinkedList;

public class ReverseLinkedListII {
    static class ListNode {
        int value;
        ListNode next;
        ListNode(int value) {
            this.value = value;
            this.next = null;
        }
    }
    public static ListNode reverseBetween(ListNode head, int left, int right) {
        if(head == null || left == right) return head;

        int pos = 1;
        ListNode temp = head;
        ListNode before = null;

        while(pos < left) {
            before = temp;
            temp = temp.next;
            pos++;
        }

        ListNode curr = temp;
        ListNode prev = null;

        for(int i = 0; i < right - left + 1; i++) {
            ListNode nextNode = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextNode;
        }

        temp.next = curr;
        if(before != null) {
            before.next = prev;
            return head;
        }
        return prev;
    }

    public static void main(String[] args) {
        ListNode head1 = new ListNode(10);
        head1.next = new ListNode(20);
        head1.next.next = new ListNode(30);
        head1.next.next.next = new ListNode(40);
        head1.next.next.next.next = new ListNode(50);

        ListNode reversedHead = reverseBetween(head1, 2, 4);
        while(reversedHead != null) {
            System.out.print(reversedHead.value + " ");
            reversedHead = reversedHead.next;
        }
    }
}
