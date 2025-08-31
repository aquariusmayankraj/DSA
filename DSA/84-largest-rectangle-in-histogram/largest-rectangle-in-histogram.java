import java.util.*;

class Solution {
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        int[] nse = new int[n];
        int[] pse = new int[n];

        Stack<Integer> stack = new Stack<>();

        // Next Smaller Element (Right side)
        Arrays.fill(nse, n);
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && heights[stack.peek()] > heights[i]) {
                nse[stack.pop()] = i;
            }
            stack.push(i);
        }

        // Clear stack for reuse
        stack.clear();

        // Previous Smaller Element (Left side)
        Arrays.fill(pse, -1);
        for (int i = n - 1; i >= 0; i--) {
            while (!stack.isEmpty() && heights[stack.peek()] > heights[i]) {
                pse[stack.pop()] = i;
            }
            stack.push(i);
        }

        // Calculate max area
        int maxArea = 0;
        for (int i = 0; i < n; i++) {
            int width = nse[i] - pse[i] - 1;
            int area = heights[i] * width;
            if (area > maxArea) {
                maxArea = area;
            }
        }
        return maxArea;
    }
}
