class Solution {
    public int[][] diagonalSort(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        for(int j=0;j<n;j++){
            sortDiagonal(mat, 0, j, m, n);
        }
        for(int i=1;i<m;i++){
            sortDiagonal(mat, i, 0, m, n);
        }
        return mat;
    }
    public void sortDiagonal(int[][] mat, int row, int col, int m, int n){
        int r = row;
        int c = col;
        List<Integer> list = new ArrayList<>();
        while(r<m && c<n){
            list.add(mat[r][c]);
            r++;
            c++;
        }
        Collections.sort(list);
        
        r=row;
        c=col;
        int index = 0;
        while(r<m && c<n){
            mat[r][c] = list.get(index++);
            r++;
            c++;
        }
    }
}