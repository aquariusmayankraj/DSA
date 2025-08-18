import java.util.*;

public class Solution {
    public int subarraySum(int[] nums, int k) {
        Map<Integer, Integer> freq = new HashMap<>();
        freq.put(0, 1);                  
        int sum = 0;
        int ans = 0;

        for (int x : nums) {
            sum += x;                 
            int need = sum - k;       
            ans += freq.getOrDefault(need, 0); 
            freq.put(sum, freq.getOrDefault(sum, 0) + 1); 
        }

        return ans;
    }
}
