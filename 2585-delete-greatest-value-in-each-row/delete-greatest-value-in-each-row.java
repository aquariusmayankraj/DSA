class Solution {
    public int deleteGreatestValue(int[][] grid) {
        int ans = 0;
        int n = grid.length;
        int m = grid[0].length;
        for (int[] row : grid) {
            Arrays.sort(row);
        }
        for (int j=0; j<m;j++) {
            int max=0;
            for (int i=0; i<n; i++) {
                max = Math.max(max, grid[i][j]);
            }
            ans += max;
        }
        return ans;
    }
}