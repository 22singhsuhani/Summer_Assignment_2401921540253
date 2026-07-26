class Solution {
    public int numComponents(ListNode head, int[] nums) {
        HashSet<Integer> set = new HashSet<>();

        for (int x : nums) {
            set.add(x);
        }

        int count = 0;
        ListNode curr = head;

        while (curr != null) {
            if (set.contains(curr.val) &&
               (curr.next == null || !set.contains(curr.next.val))) {
                count++;
            }
            curr = curr.next;
        }

        return count;
    }
}