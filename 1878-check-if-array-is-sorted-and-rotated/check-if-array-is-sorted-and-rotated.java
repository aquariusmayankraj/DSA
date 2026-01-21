class Solution {
    public boolean check(int[] nums) {
        int count = 0;
        int n = nums.length;

        for (int i = 1; i < n; i++) {
            if (nums[i] < nums[i - 1]) {
                count++;
            }
        }

        // check circular condition
        if (nums[0] < nums[n - 1]) {
            count++;
        }

        return count <= 1;
    }
}
