class Solution {
    public int[] maxSubsequence(int[] nums, int k) {
        int n = nums.length;
        int[][] pairs = new int[n][2];
        for(int i=0;i<n;i++){
            pairs[i][0] = nums[i];
            pairs[i][1] = i;
        }
        Arrays.sort(pairs,(a,b)->b[0]-a[0]);

        int[][] top = new int[k][2];
        for(int i=0;i<k;i++){
            top[i] = pairs[i];
        }
        Arrays.sort(top,(a,b)->a[1]-b[1]);

        int[] result = new int[k];
        for(int i=0;i<k;i++){
            result[i] = top[i][0];
        }
        return result;
    }
}