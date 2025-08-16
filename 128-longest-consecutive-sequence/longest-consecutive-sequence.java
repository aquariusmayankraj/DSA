import java.util.Arrays;

class Solution {
    public int longestConsecutive(int[] nums) {
        if (nums.length == 0) return 0;

        Arrays.sort(nums);

        int maxlen = 1;
        int currentlen = 1;

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i - 1]) continue;

            if (nums[i] == nums[i - 1] + 1) {
                currentlen++;
            } else {
                currentlen = 1;
            }

            maxlen = Math.max(maxlen, currentlen);
        }

        return maxlen;
    }
}
