// Question Link : https://leetcode.com/problems/best-time-to-buy-and-sell-stock-with-transaction-fee/

//Memoization Code
class Solution {
    public int maxProfit(int[] prices, int fee) {
        int dp[][] = new int[prices.length][2];
        for(int arr[] : dp){
            Arrays.fill(arr, -1);
        }
        return helper(0, 1, prices, dp, fee);   
    }
    public int helper(int ind, int buy, int[] prices, int[][] dp, int fee){
        if(ind == prices.length){
            return 0;
        }
        if(dp[ind][buy] != -1){
            return dp[ind][buy];
        }
        int profit = 0;
        if(buy == 1){
            profit = Math.max(-prices[ind]-fee +  helper(ind+1, 0, prices, dp, fee), helper(ind+1, 1, prices, dp, fee));
        }
        else{
            profit = Math.max(prices[ind] + helper(ind+1, 1, prices, dp, fee), helper(ind+1, 0, prices, dp, fee));
        }
        return dp[ind][buy] = profit;
    }
}