import java.util.*;

class Solution {
    public int minimumDistance(int[] nums) {

        Map<Integer, List<Integer>> map = new HashMap<>();

        // Step 1: store indices
        for (int i = 0; i < nums.length; i++) {
            map.computeIfAbsent(nums[i], k -> new ArrayList<>()).add(i);
        }

        int minDist = Integer.MAX_VALUE;

        // Step 2: check each list
        for (List<Integer> list : map.values()) {

            if (list.size() < 3) continue;

            for (int i = 0; i < list.size() - 2; i++) {
                int dist = 2 * (list.get(i + 2) - list.get(i));
                minDist = Math.min(minDist, dist);
            }
        }

        // Step 3: return answer
        return minDist == Integer.MAX_VALUE ? -1 : minDist;
    }
}