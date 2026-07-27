class Solution {
    public int[] nodesBetweenCriticalPoints(ListNode head) {
        if (head == null || head.next == null || head.next.next == null)
            return new int[]{-1, -1};

        int first = -1;
        int last = -1;
        int minDist = Integer.MAX_VALUE;
        int idx = 1;

        ListNode prev = head;
        ListNode curr = head.next;
        ListNode next = curr.next;

        while (next != null) {
            if ((curr.val > prev.val && curr.val > next.val) ||
                (curr.val < prev.val && curr.val < next.val)) {

                if (first == -1) {
                    first = idx;
                } else {
                    minDist = Math.min(minDist, idx - last);
                }

                last = idx;
            }

            prev = curr;
            curr = next;
            next = next.next;
            idx++;
        }

        if (first == -1 || first == last)
            return new int[]{-1, -1};

        return new int[]{minDist, last - first};
    }
}