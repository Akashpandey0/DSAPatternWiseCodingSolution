// Given the head of a linked list, rotate the list to the right by k places.

// Example 1:
// Input: head = [1,2,3,4,5], k = 2
// Output: [4,5,1,2,3]

// Example 2:
// Input: head = [0,1,2], k = 4
// Output: [2,0,1]

// Constraints:
// The number of nodes in the list is in the range [0, 500].
// -100 <= Node.val <= 100
// 0 <= k <= 2 * 109

package LinkedList;

public class RotateList {
    static class ListNode {
        int value;
        ListNode next;

        ListNode(int value) {
            this.value = value;
            this.next = null;
        }
    }

    public static ListNode rotateToRight(ListNode head, int k) {
        if(head == null) return head;

        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode lastNode = dummy.next;
        int size = 1;

        while(lastNode.next != null) {
            size++;
            lastNode = lastNode.next;
        }

        k = k % size;

        if(k == 0) {
            return dummy.next;
        }

        ListNode kth = dummy.next;
        int count = 1;

        while(kth.next != null) {
            if(count == size - k) break;
            count++;
            kth = kth.next;
        }

        lastNode.next = dummy.next;
        ListNode res = kth.next;
        kth.next = null;
        dummy.next = res;

        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode head1 = new ListNode(1);
        head1.next = new ListNode(2);
        head1.next.next = new ListNode(3);
        head1.next.next.next = new ListNode(4);
        head1.next.next.next.next = new ListNode(5);

        ListNode rotatedHead = rotateToRight(head1, 2);
        while(rotatedHead != null) {
            System.out.print(rotatedHead.value + " ");
            rotatedHead = rotatedHead.next;
        }
    }
}