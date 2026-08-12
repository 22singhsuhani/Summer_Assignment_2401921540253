class Solution {
    public boolean circularArrayLoop(int[] nums) {
        int n = nums.length;

        for (int i = 0; i < n; i++) {
            boolean forward = nums[i] > 0;
            int slow = i, fast = i;

            while (true) {
                slow = next(nums, slow, forward);
                if (slow == -1) break;

                fast = next(nums, fast, forward);
                if (fast == -1) break;

                fast = next(nums, fast, forward);
                if (fast == -1) break;

                if (slow == fast) return true;
            }
        }
        return false;
    }

    int next(int[] nums, int i, boolean forward) {
        if ((nums[i] > 0) != forward) return -1;

        int n = nums.length;
        int next = (i + nums[i]) % n;
        if (next < 0) next += n;

        if (next == i) return -1; // one element cycle

        return next;
    }
}