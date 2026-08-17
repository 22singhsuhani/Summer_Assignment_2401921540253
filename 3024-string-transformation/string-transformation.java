class Solution {
    static final long MOD = 1_000_000_007;

    public int numberOfWays(String s, String t, long k) {
        int n = s.length();

        // Find all rotations of s that equal t
        String doubled = s + s;
        int[] lps = buildLPS(t);

        long same = 0;
        long diff = 0;

        int j = 0;

        for (int i = 0; i < doubled.length() - 1; i++) {
            while (j > 0 && doubled.charAt(i) != t.charAt(j)) {
                j = lps[j - 1];
            }

            if (doubled.charAt(i) == t.charAt(j)) {
                j++;
            }

            if (j == n) {
                int start = i - n + 1;

                if (start < n) {
                    if (start == 0)
                        same++;
                    else
                        diff++;
                }

                j = lps[j - 1];
            }
        }

        /*
         * dpSame = number of ways to reach the original rotation
         * dpDiff = number of ways to reach any particular different rotation
         *
         * Transition:
         *
         * newSame = (n - 1) * diff
         * newDiff = same + (n - 2) * diff
         */

        long[][] matrix = {
            {0, n - 1},
            {1, n - 2}
        };

        long[][] result = power(matrix, k);

        // Initially we are at the original string
        long waysSame = result[0][0];
        long waysDiff = result[1][0];

        return (int)((same * waysSame + diff * waysDiff) % MOD);
    }

    private int[] buildLPS(String s) {
        int n = s.length();
        int[] lps = new int[n];

        int len = 0;

        for (int i = 1; i < n; i++) {
            while (len > 0 && s.charAt(i) != s.charAt(len)) {
                len = lps[len - 1];
            }

            if (s.charAt(i) == s.charAt(len)) {
                len++;
            }

            lps[i] = len;
        }

        return lps;
    }

    private long[][] power(long[][] a, long k) {
        long[][] result = {
            {1, 0},
            {0, 1}
        };

        while (k > 0) {
            if ((k & 1) == 1) {
                result = multiply(result, a);
            }

            a = multiply(a, a);
            k >>= 1;
        }

        return result;
    }

    private long[][] multiply(long[][] a, long[][] b) {
        long[][] c = new long[2][2];

        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                for (int x = 0; x < 2; x++) {
                    c[i][j] =
                        (c[i][j] + a[i][x] * b[x][j]) % MOD;
                }
            }
        }

        return c;
    }
}