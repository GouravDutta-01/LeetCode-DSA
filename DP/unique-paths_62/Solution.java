// Question Link : https://leetcode.com/problems/unique-paths/

//Memoization Code
class Solution {
    public int uniquePaths(int m, int n) {
        int dp[][] = new int[m][n];
        for(int[] row : dp){
            Arrays.fill(row, -1);
        }
        return countPath(m-1, n-1, dp);  
    }
    public int countPath(int i, int j, int[][] dp){
        if(i == 0 && j == 0){
            return 1;
        }
        if(i < 0 || j < 0){
            return 0;
        }
        if(dp[i][j] != -1){
            return dp[i][j];
        }
        int left = countPath(i-1, j, dp);
        int up = countPath(i, j-1, dp);
        return dp[i][j] = left + up; 
    }
}