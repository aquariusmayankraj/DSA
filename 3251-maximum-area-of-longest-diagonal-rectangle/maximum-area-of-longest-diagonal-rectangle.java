class Solution {
    public int areaOfMaxDiagonal(int[][] dimensions) {
        int ans = 0;
        long maxDiag = -1;
        for(int []rect:dimensions){
            int l = rect[0];
            int w = rect[1];
            long diag = l*l+w*w;
            int area = l*w;

            if(diag>maxDiag){
                maxDiag = diag;
                ans = area;
            }
            else if(diag == maxDiag&&area>ans){
                ans = area;
            }
        }
        return ans;
    }
}