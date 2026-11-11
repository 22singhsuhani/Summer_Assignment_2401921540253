class Solution {
    public long minEnd(int n, int x) {
        long ans = x;
        long k = n - 1;
        int bitPos = 0;

        while (k > 0) {
            if ((ans & (1L << bitPos)) == 0) {
                if ((k & 1) == 1) {
                    ans |= (1L << bitPos);
                }
                k >>= 1;
            }
            bitPos++;
        }

        return ans;
    }
}
