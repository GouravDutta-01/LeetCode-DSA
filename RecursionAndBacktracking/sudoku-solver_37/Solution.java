// Question Link : https://leetcode.com/problems/sudoku-solver/

class Solution {
    public void solveSudoku(char[][] board) {
        helper(board);
    }
    public boolean helper(char[][] board){
        for(int i=0; i<board.length; i++){
            for(int j=0; j<board[0].length; j++){
                if(board[i][j] == '.'){
                    for(char ch='1'; ch<='9'; ch++){
                        if(isValid(ch, i, j, board)){
                            board[i][j] = ch;
                            if(helper(board) == true){
                                return true;
                            }
                            else{
                                board[i][j] = '.';
                            }
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }
    public boolean isValid(char ch, int row, int col, char[][] board){
        for(int i=0; i<9; i++){
            if(board[row][i] == ch){//check row elements
                return false;
            }
            if(board[i][col] == ch){//check column elements
                return false;
            }
            if(board[3*(row/3) + i/3][3*(col/3) + i%3] == ch){//check 3*3 sub-box elements 
                return false;
            }
        }
        return true;
    }
}