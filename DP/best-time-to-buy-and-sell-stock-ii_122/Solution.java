// Question Link : https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/


//Memoization Code
class Solution {
    public int maxProfit(int[] prices) {
        int dp[][] = new int[prices.length][2];
        for(int[] val : dp){
            Arrays.fill(val, -1);
        }
        return helper(0, 1, prices, dp);    
    }
    public int helper(int i, int buy, int[] prices, int[][] dp){
        if(i == prices.length){
            return 0;
        }
        if(dp[i][buy] != -1){
            return dp[i][buy];
        }
        int profit = 0;
        if(buy == 1){
            profit = Math.max(-prices[i] + helper(i+1, 0, prices, dp), helper(i+1, 1, prices, dp));
        }
        else{
            profit = Math.max(prices[i] + helper(i+1, 1, prices, dp), helper(i+1, 0, prices, dp));
        }
        return dp[i][buy] = profit;    
    }
}