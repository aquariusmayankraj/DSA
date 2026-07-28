class Solution {
    public String[] findRelativeRanks(int[] score) {
        int n = score.length;
        String[] ans = new String[n];
        int[] temp = score.clone();
        Arrays.sort(temp);
        for(int i=0;i<n;i++){
            int rank =0;
            for(int j=n-1;j>=0;j--){
                if(score[i]==temp[j]){
                    rank = n-j;
                    break;
                }
            }
            if(rank==1){
                ans[i]="Gold Medal";
            }
            else if(rank==2){
                ans[i]="Silver Medal";
            }
            else if(rank==3){
                ans[i]="Bronze Medal";
            }
            else{
                ans[i]=String.valueOf(rank);
            }
        }
        return ans;
    }
}