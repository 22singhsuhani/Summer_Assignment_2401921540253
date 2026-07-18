/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {

    static ListNode reverse(ListNode head) {
        ListNode curr = head;
        ListNode prev = null;

        while (curr != null) {
            ListNode fwd = curr.next;
            curr.next = prev;
            prev = curr;
            curr = fwd;
        }
        return prev;
    }

    public boolean isPalindrome(ListNode head) {

        if (head == null || head.next == null)
            return true;

        // Find middle node
        ListNode slow = head;
        ListNode fast = head;

        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // Reverse second half
        ListNode head2 = slow.next;
        slow.next = null;
        head2 = reverse(head2);

        // Compare both halves
        ListNode i = head;
        ListNode j = head2;

        while (j != null) {
            if (i.val != j.val)
                return false;

            i = i.next;
            j = j.next;
        }

        return true;
    }
}

