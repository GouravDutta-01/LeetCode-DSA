// Question Link : https://leetcode.com/problems/rotting-oranges/

class Solution {
    public class Pair{
        int first;
        int second;
        int tm;
        public Pair(int first, int second, int tm){
            this.first = first;
            this.second = second;
            this.tm = tm;
        }
    }
    public int orangesRotting(int[][] grid) {
        Queue<Pair> q = new LinkedList<>();
        int vis[][] = new int[grid.length][grid[0].length];
        int countFresh = 0;
        for(int i=0; i<grid.length; i++){
            for(int j=0; j<grid[0].length; j++){
                if(grid[i][j] == 2){
                    q.add(new Pair(i, j, 0));
                    vis[i][j] = 2;
                }
                if(grid[i][j] == 1){
                    countFresh++;
                }
            }
        }
        int delRow[] = {-1, 1, 0, 0};
        int delCol[] = {0, 0, -1, 1};
        int time = 0;
        int count = 0;
        while(!q.isEmpty()){
            int row = q.peek().first;
            int col = q.peek().second;
            int t = q.peek().tm;
            q.remove();
            time = Math.max(time, t);
            for(int k=0; k<4; k++){
                int nRow = row + delRow[k];
                int nCol = col + delCol[k];
                if(nRow >= 0 && nCol >=0 && nRow < grid.length && nCol <grid[0].length && vis[nRow][nCol] == 0 && grid[nRow][nCol] == 1){
                    q.add(new Pair(nRow, nCol, time+1));
                    vis[nRow][nCol] = 2;
                    count++;
                }
            }
        }
        if(count == countFresh){
            return time;
        }
        return -1;
    }
}