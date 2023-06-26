// Question Link : https://leetcode.com/problems/best-time-to-buy-and-sell-stock-with-cooldown/

//Memoization Code
class Solution {
    public int maxProfit(int[] prices) {
        int dp[][] = new int[prices.length][2];
        for(int arr[] : dp){
            Arrays.fill(arr, -1);
        }
        return helper(0, 1, prices, dp);   
    }
    public int helper(int ind, int buy, int[] prices, int[][] dp){
        if(ind >= prices.length){
            return 0;
        }
        if(dp[ind][buy] != -1){
            return dp[ind][buy];
        }
        int profit = 0;
        if(buy == 1){
            profit = Math.max(-prices[ind] +  helper(ind+1, 0, prices, dp), helper(ind+1, 1, prices, dp));
        }
        else{
            profit = Math.max(prices[ind] + helper(ind+2, 1, prices, dp), helper(ind+1, 0, prices, dp));
        }
        return dp[ind][buy] = profit;
    }
}