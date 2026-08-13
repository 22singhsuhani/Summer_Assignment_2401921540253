class Solution {
    public ListNode removeNodes(ListNode head) {
        Stack<ListNode> st = new Stack<>();
        ListNode temp = head;

        while (temp != null) {
            while (!st.isEmpty() && st.peek().val < temp.val) {
                st.pop();
            }

            st.push(temp);
            temp = temp.next;
        }

        ListNode next = null;

        while (!st.isEmpty()) {
            ListNode top = st.pop();
            top.next = next;
            next = top;
        }

        return next;
    }
}