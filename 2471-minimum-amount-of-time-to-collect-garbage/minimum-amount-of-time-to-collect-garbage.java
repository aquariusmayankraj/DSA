class Solution {
    public int garbageCollection(String[] garbage, int[] travel) {
        int ans = 0;
        int g=0;
        int p=0;
        int m=0;
        for(int i=0;i<garbage.length;i++){
            ans+=garbage[i].length();
            if(garbage[i].contains("G")){
                g=i;
            }
            if(garbage[i].contains("P")){
                p=i;
            }
            if(garbage[i].contains("M")){
                m=i;
            }
        }
        for(int i=0;i<g;i++){
            ans+=travel[i];
        }
        for(int i=0;i<p;i++){
            ans+=travel[i];
        }
        for(int i=0;i<m;i++){
            ans+=travel[i];
        }
        return ans;
    }
}