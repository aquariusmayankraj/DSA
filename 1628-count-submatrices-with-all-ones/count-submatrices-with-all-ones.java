class Solution {
    public int numSubmat(int[][] mat) {
        int m = mat.length, n = mat[0].length;
        int[][] width = new int[m][n];
        int res = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (mat[i][j] == 1) {
                    width[i][j] = (j == 0 ? 1 : width[i][j - 1] + 1);

                    int minWidth = width[i][j];
                    for (int k = i; k >= 0; k--) {
                        if (width[k][j] == 0) break;
                        minWidth = Math.min(minWidth, width[k][j]);
                        res += minWidth;
                    }
                }
            }
        }
        return res;
    }
}
