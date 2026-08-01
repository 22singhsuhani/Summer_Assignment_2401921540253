import java.util.Random;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */

class Solution {

    private ListNode head;
    private Random random;

    public Solution(ListNode head) {
        this.head = head;
        this.random = new Random();
    }

    public int getRandom() {
        int result = head.val;
        ListNode curr = head;
        int count = 1;

        while (curr != null) {
            if (random.nextInt(count) == 0) {
                result = curr.val;
            }
            curr = curr.next;
            count++;
        }

        return result;
    }
}