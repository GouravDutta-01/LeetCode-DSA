// Question Link : https://leetcode.com/problems/number-of-enclaves/

class Solution {
    class Pair{
        int first;
        int second;
        public Pair(int first, int second){
            this.first = first;
            this.second = second;
        }
    }
    public int numEnclaves(int[][] grid) {
        Queue<Pair> q = new LinkedList<>();
        int vis[][] = new int[grid.length][grid[0].length];
        for(int j=0; j<grid[0].length; j++){
            //first row
            if(grid[0][j] == 1){
                q.add(new Pair(0, j));
                vis[0][j] = 1;
            }
            //last row
            if(grid[grid.length-1][j] == 1){
                q.add(new Pair(grid.length-1, j));
                vis[grid.length-1][j] = 1;
            }
        }
        for(int i=0; i<grid.length; i++){
            //first col
            if(grid[i][0] == 1){
                q.add(new Pair(i, 0));
                vis[i][0] = 1;
            }
            //last col
            if(grid[i][grid[0].length-1] == 1){
                q.add(new Pair(i, grid[0].length-1));
                vis[i][grid[0].length-1] = 1;
            }
        } 
        int delRow[] = {-1, +1, 0, 0};
        int delCol[] = {0, 0, -1, +1};
        while(!q.isEmpty()){
            int row = q.peek().first;
            int col = q.peek().second;
            q.remove();
            for(int k=0; k<4; k++){
                int nRow = row + delRow[k];
                int nCol = col + delCol[k];
                if(nRow >= 0 && nCol >= 0 && nRow < grid.length && nCol < grid[0].length && grid[nRow][nCol] == 1 && vis[nRow][nCol] == 0){
                    q.add(new Pair(nRow, nCol));
                    vis[nRow][nCol] = 1;
                }
            }
        }
        int count = 0; 
        for(int i=0; i<grid.length; i++){
            for(int j=0; j<grid[0].length; j++){
                if(grid[i][j] == 1 && vis[i][j] == 0){
                    count++;
                }
            }
        } 
        return count;   
    }
}