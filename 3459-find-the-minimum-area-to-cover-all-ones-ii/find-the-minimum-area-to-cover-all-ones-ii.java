class Solution {
    public int minimumSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int ans = m * n;  // Upper bound: whole grid area times 3, but safe init

        // Horizontal split then vertical splits in bottom part
        for (int i = 0; i < m; ++i) {
            int top = minimumArea(grid, 0, i, 0, n - 1);
            for (int j = 0; j < n; ++j) {
                int leftBottom = minimumArea(grid, i + 1, m - 1, 0, j);
                int rightBottom = minimumArea(grid, i + 1, m - 1, j + 1, n - 1);
                ans = Math.min(ans, top + leftBottom + rightBottom);
            }
        }

        // Horizontal split then vertical splits in top part
        for (int i = 0; i < m; ++i) {
            int bottom = minimumArea(grid, i, m - 1, 0, n - 1);
            for (int j = 0; j < n; ++j) {
                int leftTop = minimumArea(grid, 0, i - 1, 0, j);
                int rightTop = minimumArea(grid, 0, i - 1, j + 1, n - 1);
                ans = Math.min(ans, bottom + leftTop + rightTop);
            }
        }

        // Vertical split then horizontal splits in the left part
        for (int j = 0; j < n; ++j) {
            int left = minimumArea(grid, 0, m - 1, 0, j);
            for (int i = 0; i < m; ++i) {
                int topRight = minimumArea(grid, 0, i, j + 1, n - 1);
                int bottomRight = minimumArea(grid, i + 1, m - 1, j + 1, n - 1);
                ans = Math.min(ans, left + topRight + bottomRight);
            }
        }

        // Vertical split then horizontal splits in the right part
        for (int j = 0; j < n; ++j) {
            int right = minimumArea(grid, 0, m - 1, j, n - 1);
            for (int i = 0; i < m; ++i) {
                int topLeft = minimumArea(grid, 0, i, 0, j - 1);
                int bottomLeft = minimumArea(grid, i + 1, m - 1, 0, j - 1);
                ans = Math.min(ans, right + topLeft + bottomLeft);
            }
        }

        // Two horizontal cuts for three horizontal rectangles
        for (int i1 = 0; i1 < m; ++i1) {
            for (int i2 = i1 + 1; i2 < m; ++i2) {
                ans = Math.min(ans,
                    minimumArea(grid, 0, i1, 0, n - 1) +
                    minimumArea(grid, i1 + 1, i2, 0, n - 1) +
                    minimumArea(grid, i2 + 1, m - 1, 0, n - 1)
                );
            }
        }

        // Two vertical cuts for three vertical rectangles
        for (int j1 = 0; j1 < n; ++j1) {
            for (int j2 = j1 + 1; j2 < n; ++j2) {
                ans = Math.min(ans,
                    minimumArea(grid, 0, m - 1, 0, j1) +
                    minimumArea(grid, 0, m - 1, j1 + 1, j2) +
                    minimumArea(grid, 0, m - 1, j2 + 1, n - 1)
                );
            }
        }

        return ans;
    }

    // Helper to compute the minimal rectangle area enclosing all 1s in submatrix
    private int minimumArea(int[][] grid, int si, int ei, int sj, int ej) {
        int x1 = Integer.MAX_VALUE, y1 = Integer.MAX_VALUE;
        int x2 = 0, y2 = 0;
        for (int i = si; i <= ei; ++i) {
            for (int j = sj; j <= ej; ++j) {
                if (grid[i][j] == 1) {
                    x1 = Math.min(x1, i);
                    y1 = Math.min(y1, j);
                    x2 = Math.max(x2, i);
                    y2 = Math.max(y2, j);
                }
            }
        }
        if (x1 == Integer.MAX_VALUE) return 0;
        return (x2 - x1 + 1) * (y2 - y1 + 1);
    }
}
