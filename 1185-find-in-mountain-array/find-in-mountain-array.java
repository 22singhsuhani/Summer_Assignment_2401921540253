/**
 * // This is MountainArray's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface MountainArray {
 *     public int get(int index);
 *     public int length();
 * }
 */

class Solution {
    public int findInMountainArray(int target, MountainArray mountainArr) {
        int n = mountainArr.length();
        
        // Step 1: Find the peak of the mountain array
        int peak = findPeak(mountainArr, 0, n - 1);
        
        // Step 2: Binary search on the strictly increasing left side
        int leftIndex = binarySearch(mountainArr, target, 0, peak, true);
        if (leftIndex != -1) {
            return leftIndex;
        }
        
        // Step 3: Binary search on the strictly decreasing right side
        return binarySearch(mountainArr, target, peak + 1, n - 1, false);
    }
    
    private int findPeak(MountainArray mountainArr, int left, int right) {
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (mountainArr.get(mid) < mountainArr.get(mid + 1)) {
                left = mid + 1; // Peak must be to the right
            } else {
                right = mid;    // Peak is at mid or to the left
            }
        }
        return left;
    }
    
    private int binarySearch(MountainArray mountainArr, int target, int left, int right, boolean isAscending) {
        while (left <= right) {
            int mid = left + (right - left) / 2;
            int midVal = mountainArr.get(mid);
            
            if (midVal == target) {
                return mid;
            }
            
            if (isAscending) {
                if (midVal < target) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            } else { // Descending order search logic
                if (midVal > target) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }
        return -1;
    }
}
