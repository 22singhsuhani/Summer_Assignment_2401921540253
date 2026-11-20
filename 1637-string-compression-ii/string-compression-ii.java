class Solution {
    int[][] dp;

    public int getLengthOfOptimalCompression(String s, int k) {
        int n = s.length();
        dp = new int[n][k + 1];

        for (int[] row : dp)
            Arrays.fill(row, -1);

        return solve(s, 0, k);
    }

    int solve(String s, int i, int k) {
        if (k < 0) return 999;
        if (i == s.length()) return 0;

        if (dp[i][k] != -1) return dp[i][k];

        int ans = solve(s, i + 1, k - 1);

        int same = 0, diff = 0;

        for (int j = i; j < s.length(); j++) {
            if (s.charAt(j) == s.charAt(i))
                same++;
            else
                diff++;

            if (diff > k) break;

            int len = 1;
            if (same >= 2) len++;
            if (same >= 10) len++;
            if (same >= 100) len++;

            ans = Math.min(ans, len + solve(s, j + 1, k - diff));
        }

        return dp[i][k] = ans;   }
}