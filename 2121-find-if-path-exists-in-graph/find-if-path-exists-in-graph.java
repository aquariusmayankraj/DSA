class Solution {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        if(source==destination){
            return true;
        }
        List<List<Integer>> graph = new ArrayList<>();
        for(int i=0;i<n;i++){
            graph.add(new ArrayList<>());
        }
        for(int[] edge: edges){
            int u=edge[0];
            int v=edge[1];
            graph.get(u).add(v);
            graph.get(v).add(u);
        }
        boolean[] visited = new boolean[n];
        return dfs(graph, visited, source, destination);
    }
    private boolean dfs(List<List<Integer>> graph, boolean[] visited, int current, int destination){
        if(current==destination){
            return true;
        }
        visited[current] = true;
        for(int neighbour:graph.get(current)){
            if(!visited[neighbour]){
                if(dfs(graph, visited, neighbour, destination)){
                    return true;
                }
            }
        }
        return false;
    }
}