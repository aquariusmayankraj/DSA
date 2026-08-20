class Solution {
    public int maximumBags(int[] capacity, int[] rocks, int additionalRocks) {
        int n = capacity.length;
        int[] needed = new int[n];
        for(int i=0;i<n;i++){
            needed[i]=capacity[i]-rocks[i];
        }
        Arrays.sort(needed);
        int count = 0;
        for(int i=0;i<n;i++){
            if(additionalRocks>=needed[i]){
                additionalRocks-=needed[i];
                count++;
            }
        }
        return count;
    }
}