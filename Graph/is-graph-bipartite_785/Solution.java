// Question Link : https://leetcode.com/problems/is-graph-bipartite/

class Solution {
    public boolean isBipartite(int[][] graph) {
        int col[] = new int[graph.length];
        Arrays.fill(col, -1);
        Queue<Integer> q = new LinkedList<>();
        for(int i=0; i<graph.length; i++){
            if(col[i] == -1){
                q.add(i);
                col[i] = 0;
                while(!q.isEmpty()){
                    int curr = q.remove();
                    for(int j=0; j<graph[curr].length; j++){
                        int dest = graph[curr][j];
                        if(col[dest] == -1){
                            col[dest] = (col[curr] == 0) ? 1 : 0;;
                            q.add(dest);
                        }
                        else if(col[dest] == col[curr]){
                            return false;
                        }
                    }
                }
            }
        }
        return true;
    }
}