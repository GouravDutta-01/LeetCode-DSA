// Question Link : https://leetcode.com/problems/number-of-islands/

class Solution {
    class Pair{
        int first;
        int second;
        public Pair(int first, int second){
            this.first = first;
            this.second = second;
        }
    }
    public int numIslands(char[][] grid) {
        int vis[][] = new int[grid.length][grid[0].length];
        int count = 0;
        for(int i=0; i<grid.length; i++){
            for(int j=0; j<grid[0].length; j++){
                if(grid[i][j] == '1' && vis[i][j] == 0){
                    count++;
                    bfs(i, j, grid, vis);
                }
            }
        } 
        return count; 
    }
    public void bfs(int i, int j, char[][] grid, int[][] vis){
        vis[i][j] = 1;
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(i, j));
        while(!q.isEmpty()){
            int row = q.peek().first;
            int col = q.peek().second;
            q.remove();
            int delRow[] = {-1, +1, 0, 0};
            int delCol[] = {0, 0, -1, +1};
            for(int k=0; k<4; k++){
                int nRow = row + delRow[k];
                int nCol = col + delCol[k];
                if(nRow >= 0 && nCol >= 0 && nRow < grid.length && nCol < grid[0].length && grid[nRow][nCol] == '1' && vis[nRow][nCol] == 0){
                    vis[nRow][nCol] = 1;
                    q.add(new Pair(nRow, nCol));
                }
            }
        }
    }
}