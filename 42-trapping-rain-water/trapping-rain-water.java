class Solution {
    public int trap(int[] height) {
        int left = 1;
        int right = height.length - 2;
        int lmax = height[0];
        int rmax = height[height.length - 1];
        int result = 0;

        while (left <= right) {
            if (lmax <= rmax) {
                result += Math.max(0, lmax - height[left]);
                lmax = Math.max(lmax, height[left]);
                left++;
            } 
            else {
                result += Math.max(0, rmax - height[right]);
                rmax = Math.max(rmax, height[right]);
                right--;
            }
        }

        return result;
    }
}
