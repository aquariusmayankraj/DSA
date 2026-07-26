class Solution {
    public int[] kWeakestRows(int[][] mat, int k) {
        int m = mat.length;
        int n = mat[0].length;
        int[][] rows = new int[m][2];
        for(int i=0;i<m;i++){
            int soldiers = 0;
            for(int j=0;j<n;j++){
                if(mat[i][j]==1) soldiers++;
                else break;
            }
            rows[i][0] = soldiers;
            rows[i][1] = i;
        }
        Arrays.sort(rows,(a,b)->{
            if(a[0]!=b[0]) return a[0]-b[0];
            return a[1]-b[1];
        });

        int[] result = new int[k];
        for(int i=0;i<k;i++){
            result[i] = rows[i][1];
        }
        return result;
    }
}