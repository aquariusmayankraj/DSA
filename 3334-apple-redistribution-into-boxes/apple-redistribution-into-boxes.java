class Solution {
    public int minimumBoxes(int[] apple, int[] capacity) {
        int totalApples = 0;
        for (int a : apple) {
            totalApples += a;
        }
        Arrays.sort(capacity);
        int accumulatedCapacity = 0;
        int boxesUsed = 0;
        for (int i = capacity.length - 1; i >= 0; i--) {
            accumulatedCapacity += capacity[i];
            boxesUsed++;
            if (accumulatedCapacity >= totalApples) {
                return boxesUsed;
            }
        }
        return boxesUsed;
    }
}