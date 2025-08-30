import java.util.*;

class Solution {
    public int sumSubarrayMins(int[] arr) {
        int n = arr.length;
        long sum = 0;
        int mod = 1_000_000_007;

        Stack<Integer> stack = new Stack<>();
        int[] prevSmaller = new int[n];
        int[] nextSmaller = new int[n];
        Arrays.fill(prevSmaller, -1);
        Arrays.fill(nextSmaller, n);

        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && arr[i] < arr[stack.peek()]) {
                nextSmaller[stack.pop()] = i;
            }
            stack.push(i);
        }

        stack.clear();

        for (int i = n - 1; i >= 0; i--) {
            while (!stack.isEmpty() && arr[i] <= arr[stack.peek()]) {
                prevSmaller[stack.pop()] = i;
            }
            stack.push(i);
        }

        for (int i = 0; i < n; i++) {
            long count = (long)(i - prevSmaller[i]) * (nextSmaller[i] - i);
            sum = (sum + arr[i] * count) % mod;
        }

        return (int) sum;
    }
}
