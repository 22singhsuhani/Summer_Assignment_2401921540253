import java.util.Stack;

class Solution {
    public int largestRectangleArea(int[] heights) {
        if (heights == null || heights.length == 0) {
            return 0;
        }
        
        Stack<Integer> stack = new Stack<>();
        int maxArea = 0;
        int n = heights.length;
        
        for (int i = 0; i <= n; i++) {
            // Use a dummy height of 0 for the end of the array to clear out the stack
            int currentHeight = (i == n) ? 0 : heights[i];
            
            // Maintain a monotonic increasing stack
            while (!stack.isEmpty() && heights[stack.peek()] > currentHeight) {
                int height = heights[stack.pop()];
                
                // If stack is empty, it means the popped height was the smallest so far
                int width = stack.isEmpty() ? i : i - stack.peek() - 1;
                
                maxArea = Math.max(maxArea, height * width);
            }
            stack.push(i);
        }
        
        return maxArea;
    }
}