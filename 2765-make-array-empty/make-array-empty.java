import java.util.Arrays;

class Solution {
    public long countOperationsToEmptyArray(int[] nums) {
        int n = nums.length;
        Integer[] indices = new Integer[n];
        for (int i = 0; i < n; i++) {
            indices[i] = i;
        }
        
        // Sort indices array based on the actual values in nums
        Arrays.sort(indices, (i, j) -> Integer.compare(nums[i], nums[j]));
        
        long ans = n;
        for (int i = 1; i < n; i++) {
            if (indices[i] < indices[i - 1]) {
                ans += (n - i);
            }
        }
        
        return ans;
    }
}
