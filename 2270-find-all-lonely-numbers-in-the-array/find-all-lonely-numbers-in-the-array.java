
class Solution {
    public List<Integer> findLonely(int[] nums) {
        Map<Integer, Integer> freq = new HashMap<>();

        for (int num : nums) {
            freq.put(num, freq.getOrDefault(num, 0) + 1);
        }

        List<Integer> arr = new ArrayList<>();

        for (int num : nums) {
            if (freq.get(num) == 1 &&
                !freq.containsKey(num - 1) &&
                !freq.containsKey(num + 1)) {
                arr.add(num);
            }
        }

        return arr;
    }
}
