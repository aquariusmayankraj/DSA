class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> room) {
        int n=room.size();
        boolean[] visited = new boolean[n];
        dfs(room, visited, 0);
        for(boolean is:visited){
            if(!is){
                return false;
            }
        }
        return true;
    }
    private void dfs(List<List<Integer>> room, boolean[] visited, int current){
        visited[current]=true;
        for(int key:room.get(current)){
            if(!visited[key]){
                dfs(room, visited, key);
            }
        }
    }
}