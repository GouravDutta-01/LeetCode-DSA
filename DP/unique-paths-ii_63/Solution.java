// Question Link : https://leetcode.com/problems/unique-paths-ii/

//Tabulation Code
class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int dp[][] = new int[obstacleGrid.length][obstacleGrid[0].length];
        for(int i=0; i<obstacleGrid.length; i++){
            for(int j=0; j<obstacleGrid[0].length; j++){
              if(obstacleGrid[i][j] == 1){
                dp[i][j] = 0;
              }
              else if(i == 0 && j == 0){
                dp[i][j] = 1;
              }
              else{
                int up = 0;
                int left = 0;
                if(i>0)
                 up = dp[i-1][j];
                if(j>0)
                 left = dp[i][j-1];
                dp[i][j] = up + left;
              }
            }
        }
        return dp[obstacleGrid.length-1][obstacleGrid[0].length-1];
    }
}