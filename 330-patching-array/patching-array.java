class Solution {
    public int minPatches(int[] nums, int n) {
        long miss = 1;   // Smallest number that cannot be formed
        int i = 0;
        int patches = 0;

        while (miss <= n) {
            if (i < nums.length && nums[i] <= miss) {
                miss += nums[i];
                i++;
            } else {
                // Patch with 'miss'
                miss += miss;
                patches++;
            }
        }

        return patches;
    }
}