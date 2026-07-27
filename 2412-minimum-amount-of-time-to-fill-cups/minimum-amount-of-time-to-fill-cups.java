class Solution {
    public int fillCups(int[] amount) {
        int ans = 0;
        while (amount[0] != 0 || amount[1] != 0 || amount[2] != 0) {
            Arrays.sort(amount);
            if (amount[2] > 0)
                amount[2]--;
            if (amount[1] > 0)
                amount[1]--;
            ans++;
        }
        return ans;
    }
}