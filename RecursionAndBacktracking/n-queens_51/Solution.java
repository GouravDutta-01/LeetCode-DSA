// Question Link : https://leetcode.com/problems/n-queens/

class Solution {
    public List<List<String>> solveNQueens(int n) {
        char board[][] = new char[n][n];
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                board[i][j] = '.';
            }
        }
        List<List<String>> ans = new ArrayList<>();
        nQueens(board, 0, ans);
        return ans;
    }
    public void nQueens(char[][] board, int row, List<List<String>> ans){
        if(row == board.length){
            ans.add(construct(board));
            return;
        }
        for(int col=0; col<board.length; col++){
            if(isSafe(board, row, col)){
                board[row][col] = 'Q';
                nQueens(board, row+1, ans);
                board[row][col] = '.';
            }
        }
    }
    public List<String> construct(char board[][]){
        List<String> list = new ArrayList<>();
        for(int i=0; i<board.length; i++){
            String str = new String(board[i]);
            list.add(str);
        }
        return list;
    }
    public boolean isSafe(char[][] board, int row, int col){
        int tempRow = row;
        int tempCol = col;
        while(row>=0 && col>=0){
            if(board[row][col] == 'Q'){
                return false;
            }
            row--;
            col--;
        }
        row = tempRow;
        col = tempCol;
        while(row>=0 && col<board[0].length){
            if(board[row][col] == 'Q'){
                return false;
            }
            row--;
            col++;
        }
        row = tempRow;
        col = tempCol;
        while(row>=0){
            if(board[row][col] == 'Q'){
                return false;
            }
            row--;
        }
        return true;
    }
}