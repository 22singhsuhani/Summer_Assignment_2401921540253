class Solution {
    public int countOfPairs(int[] nums) {
        int n = nums.length;
        int maxVal = 1000; 
        long MOD = 1_000_000_007;
        
        // dp[v] stores the number of valid pairs ending at the current index with arr1[i] = v
        long[] dp = new long[maxVal + 1];
        
        // Base case: initialize for index 0
        for (int v = 0; v <= nums[0]; v++) {
            dp[v] = 1;
        }
        
        // Iterate through the rest of the array
        for (int i = 1; i < n; i++) {
            long[] nextDp = new long[maxVal + 1];
            
            // Build prefix sum array of the current dp state
            long[] pref = new long[maxVal + 1];
            pref[0] = dp[0];
            for (int j = 1; j <= maxVal; j++) {
                pref[j] = (pref[j - 1] + dp[j]) % MOD;
            }
            
            // Fill nextDp for the current element nums[i]
            for (int v = 0; v <= nums[i]; v++) {
                int maxJ = Math.min(v, v - nums[i] + nums[i - 1]);
                if (maxJ >= 0) {
                    nextDp[v] = pref[maxJ];
                }
            }
            dp = nextDp;
        }
        
        // Sum up all possibilities from the last element
        long totalPairs = 0;
        for (int v = 0; v <= maxVal; v++) {
            totalPairs = (totalPairs + dp[v]) % MOD;
        }
        
        return (int) totalPairs;
    }
}
