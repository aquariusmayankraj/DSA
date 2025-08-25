class Solution {
    public int[] findDiagonalOrder(int[][] mat) {
        int m = mat.length, n = mat[0].length;
        int[] result = new int[m * n];
        int r = 0, c = 0, idx = 0;
        boolean up = true;

        while (idx < m * n) {
            result[idx++] = mat[r][c];

            if (up) {
                if (c == n - 1) { r++; up = false; }
                else if (r == 0) { c++; up = false; }
                else { r--; c++; }
            } else {
                if (r == m - 1) { c++; up = true; }
                else if (c == 0) { r++; up = true; }
                else { r++; c--; }
            }
        }
        return result;
    }
}
