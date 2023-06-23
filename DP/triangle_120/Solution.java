// Question Link : https://leetcode.com/problems/triangle/

//Memoization Code
class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int dp[][] = new int[triangle.size()][triangle.get(triangle.size()-1).size()];
        for(int val[] : dp){
            Arrays.fill(val, -1);
        }
        return helper(triangle, 0, 0, dp);
    }
    public int helper(List<List<Integer>> triangle, int i, int j, int dp[][]){
        if(i == triangle.size()-1){
            return triangle.get(i).get(j);
        }
        if(dp[i][j] != -1){
            return dp[i][j];
        }
        int down = triangle.get(i).get(j) + helper(triangle, i+1, j, dp);
        int diag = triangle.get(i).get(j) + helper(triangle, i+1, j+1, dp);
        return dp[i][j] = Math.min(down, diag); 

    }
}