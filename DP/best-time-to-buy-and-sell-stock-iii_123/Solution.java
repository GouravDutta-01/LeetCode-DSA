// Question Link : https://leetcode.com/problems/best-time-to-buy-and-sell-stock-iii/

//Memoization Code
class Solution {
    public int maxProfit(int[] prices) {
        int dp[][][] = new int[prices.length][2][3];
        for(int val[][] : dp){
            for(int val1[] : val){
                Arrays.fill(val1, -1);
            }
        }
        return helper(0, 1, 2, prices, dp);   
    }
    public int helper(int ind, int buy, int count, int[] prices, int[][][] dp){
        if(ind == prices.length || count == 0){
            return 0;
        }
        if(dp[ind][buy][count] != -1){
            return dp[ind][buy][count];
        }
        int profit = 0;
        if(buy == 1){
            profit = Math.max(-prices[ind] + helper(ind+1, 0, count, prices, dp), helper(ind+1, 1, count, prices, dp));
        }
        else{
            profit = Math.max(prices[ind] + helper(ind+1, 1, count-1, prices, dp), helper(ind+1, 0, count, prices, dp));
        }
        return dp[ind][buy][count] = profit;
    }
}