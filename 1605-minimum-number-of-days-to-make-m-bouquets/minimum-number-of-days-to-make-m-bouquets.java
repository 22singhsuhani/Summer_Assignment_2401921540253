class Solution {
    public int minDays(int[] bloomDay, int m, int k) {

        if ((long)m * k > bloomDay.length) {
            return -1;
        }

        int left = Integer.MAX_VALUE;
        int right = Integer.MIN_VALUE;

        for (int x : bloomDay) {
            left = Math.min(left, x);
            right = Math.max(right, x);
        }

        while (left <= right) {

            int mid = left + (right - left) / 2;

            int flowers = 0;
            int bouquet = 0;

            for (int x : bloomDay) {

                if (x <= mid) {
                    flowers++;

                    if (flowers == k) {
                        bouquet++;
                        flowers = 0;
                    }
                } else {
                    flowers = 0;
                }
            }

            if (bouquet >= m) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return left;
    }
}