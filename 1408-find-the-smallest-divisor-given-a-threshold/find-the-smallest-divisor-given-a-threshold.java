class Solution {
    public int smallestDivisor(int[] nums, int threshold) {
        int low = 1;
        int high = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > high) {
                high = nums[i];
            }
        }
        
        int result = high;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            int sum = 0;

            for (int i = 0; i < nums.length; i++) {
                sum += (nums[i] + mid - 1) / mid; 
            }
            
            if (sum > threshold) {
                low = mid + 1;
            } else {
                result = mid; 
                high = mid - 1; 
            }
        }
        
        return result;
    }
}
