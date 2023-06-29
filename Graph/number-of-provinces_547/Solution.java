// Question Link : https://leetcode.com/problems/number-of-provinces/

class Solution {
    public int findCircleNum(int[][] isConnected) {
        boolean vis[] = new boolean[isConnected.length];
        int count = 0;
        for(int i=0; i<isConnected.length; i++){
            if(!vis[i]){
                count++;
                dfs(i, vis, isConnected);
            }
        }
        return count;
    }
    public void dfs(int curr, boolean[] vis, int[][] isConnected){
            vis[curr] = true;
            for(int j=0; j<isConnected[curr].length; j++){
                if(!vis[j] && isConnected[curr][j] == 1){
                    dfs(j, vis, isConnected);
                }
            }
        }
}