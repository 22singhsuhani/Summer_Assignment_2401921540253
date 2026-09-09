class Solution {
    public double findMedianSortedArrays(int[] a, int[] b) {

        // Binary search smaller array par
        if (a.length > b.length) {
            return findMedianSortedArrays(b, a);
        }

        int n = a.length;
        int m = b.length;

        int left = 0;
        int right = n;

        while (left <= right) {

            int cut1 = left + (right - left) / 2;

            int cut2 = (m + n + 1) / 2 - cut1;

            int left1 = (cut1 == 0)
                    ? Integer.MIN_VALUE
                    : a[cut1 - 1];

            int right1 = (cut1 == n)
                    ? Integer.MAX_VALUE
                    : a[cut1];

            int left2 = (cut2 == 0)
                    ? Integer.MIN_VALUE
                    : b[cut2 - 1];

            int right2 = (cut2 == m)
                    ? Integer.MAX_VALUE
                    : b[cut2];

            if (left1 <= right2 && left2 <= right1) {

                if ((m + n) % 2 == 1) {
                    return Math.max(left1, left2);
                }

                return (Math.max(left1, left2)
                        + Math.min(right1, right2)) / 2.0;
            }

            else if (left1 > right2) {
                right = cut1 - 1;
            }

            else {
                left = cut1 + 1;
            }
        }

        return 0.0;
    }
}