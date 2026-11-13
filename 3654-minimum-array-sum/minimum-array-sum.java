class Solution {

    int[][][] dp;

    public int minArraySum(int[] nums, int k, int op1, int op2) {

        int n = nums.length;

        dp = new int[n][op1 + 1][op2 + 1];

        for (int[][] a : dp) {
            for (int[] b : a) {
                Arrays.fill(b, -1);
            }
        }

        return solve(0, op1, op2, nums, k);
    }

    int solve(int i, int op1, int op2, int[] nums, int k) {

        if (i == nums.length) {
            return 0;
        }

        if (dp[i][op1][op2] != -1) {
            return dp[i][op1][op2];
        }

        int x = nums[i];

        // Option 1: No operation
        int ans = x + solve(i + 1, op1, op2, nums, k);

        // Option 2: Apply Operation 1
        if (op1 > 0) {
            int val = (x + 1) / 2;

            ans = Math.min(ans,
                val + solve(i + 1, op1 - 1, op2, nums, k));
        }

        // Option 3: Apply Operation 2
        if (op2 > 0 && x >= k) {

            int val = x - k;

            ans = Math.min(ans,
                val + solve(i + 1, op1, op2 - 1, nums, k));
        }

        // Option 4: Apply both operations
        if (op1 > 0 && op2 > 0) {

            // First Operation 1, then Operation 2
            int a = (x + 1) / 2;

            if (a >= k) {
                int val = a - k;

                ans = Math.min(ans,
                    val + solve(i + 1, op1 - 1, op2 - 1, nums, k));
            }

            // First Operation 2, then Operation 1
            if (x >= k) {
                int b = (x - k + 1) / 2;

                ans = Math.min(ans,
                    b + solve(i + 1, op1 - 1, op2 - 1, nums, k));
            }
        }

        return dp[i][op1][op2] = ans;
    }
}