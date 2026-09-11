class Solution {
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        boolean[] visited = new boolean[n];
        int provincies = 0;
        for(int i=0;i<n;i++){
            if(!visited[i]){
                provincies++;
                dfs(i,isConnected,visited);
            }
        }
        return provincies;
    }
    public void dfs(int city, int[][] isConnected, boolean[] isVisited){
        isVisited[city] = true;
        for(int i=0; i<isConnected.length; i++){
            if(isConnected[city][i]==1 && !isVisited[i]){
                dfs(i,isConnected,isVisited);
            }
        }
    }
}