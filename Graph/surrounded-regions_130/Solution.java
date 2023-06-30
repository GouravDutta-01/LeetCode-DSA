// Question Link : https://leetcode.com/problems/surrounded-regions/

class Solution {
    public void solve(char[][] board) {
        int vis[][] = new int[board.length][board[0].length];
        for(int j=0; j<board[0].length; j++){
            //first row
            if(vis[0][j] == 0 && board[0][j] == 'O'){
                dfs(0, j, board, vis);
            }
            //last row
            if(vis[board.length-1][j] == 0 && board[board.length-1][j] == 'O'){
                dfs(board.length-1, j, board, vis);
            }
        }
        for(int i=0; i<board.length; i++){
            //first col
            if(vis[i][0] == 0 && board[i][0] == 'O'){
                dfs(i, 0, board, vis);
            }
            //last col
            if(vis[i][board[0].length-1] == 0 && board[i][board[0].length-1] == 'O'){
                dfs(i, board[0].length-1, board, vis);
            }
        }
        for(int i=0; i<board.length; i++){
            for(int j=0; j<board[0].length; j++){
                if(vis[i][j] == 0 && board[i][j] == 'O'){
                    board[i][j] = 'X';
                }
            }
        }  
    }
    public void dfs(int row, int col, char[][] board, int[][] vis){
        if(row < 0 || col < 0 || row >= board.length || col >= board[0].length || vis[row][col] == 1 || board[row][col] != 'O'){
            return;
        }
        vis[row][col] = 1;
        dfs(row-1, col, board, vis);
        dfs(row+1, col, board, vis);
        dfs(row, col-1, board, vis);
        dfs(row, col+1, board, vis);
    }
}