import java.util.HashSet;

class Solution {
    public int findPairs(int[] nums, int k) {
        if (k < 0) return 0;
        HashSet<Integer> set = new HashSet<>();
        HashSet<Integer> ans = new HashSet<>();
        for (int num : nums) {
            if (set.contains(num - k)) {
                ans.add(num - k);
            }
            if (set.contains(num + k)) {
                ans.add(num);
            }
            set.add(num);
        }
        return ans.size();
    }
}