// Question Link : https://leetcode.com/problems/find-eventual-safe-states/

class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int vis[] = new int[graph.length];
        int pathVis[] = new int[graph.length];
        int check[] = new int[graph.length];
        for(int i=0; i<graph.length; i++){
            if(vis[i] == 0){
                dfsCheck(i, graph, vis, pathVis, check);
            }
        }
        List<Integer> safeNodes = new ArrayList<>();
        for(int i=0; i<graph.length; i++){
            if(check[i] == 1){
                safeNodes.add(i);
            }
        }
        return safeNodes;   
    }
    public boolean dfsCheck(int i, int[][] graph, int[] vis, int[] pathVis, int[] check){
        vis[i] = 1;
        pathVis[i] = 1;
        check[i] = 0;
        for(int j=0; j<graph[i].length; j++){
            if(vis[graph[i][j]] == 0){
                if(dfsCheck(graph[i][j], graph, vis, pathVis, check)){
                    return true;
                }
            }
            else if(pathVis[graph[i][j]] == 1){
                return true;
            }
        }
        check[i] = 1;
        pathVis[i] = 0;
        return false;
    }
}