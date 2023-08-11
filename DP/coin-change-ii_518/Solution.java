// Question Link : https://leetcode.com/problems/coin-change-ii/

//Memoization Code
class Solution {
    public int change(int amount, int[] coins) {
        int dp[][] = new int[coins.length][amount+1];
        for(int[] row : dp){
            Arrays.fill(row, -1);
        }
        return helper(coins.length-1, amount, coins, dp);    
    }
    public int helper(int ind, int amount, int[] coins, int[][] dp){
        if(ind == 0){
            return (amount % coins[0] == 0) ? 1:0;
        }
        if(dp[ind][amount] != -1){
            return dp[ind][amount];
        }
        int notTake = helper(ind-1, amount, coins, dp);
        int take = 0;
        if(coins[ind] <= amount){
            take = helper(ind, amount-coins[ind], coins, dp);
        }
        return dp[ind][amount] = take + notTake;
    }
}