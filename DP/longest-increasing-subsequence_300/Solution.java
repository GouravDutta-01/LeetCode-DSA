// Question Link : https://leetcode.com/problems/longest-increasing-subsequence/

//Memoization Code
class Solution {
    public int lengthOfLIS(int[] nums) {
        int dp[][] = new int[nums.length][nums.length+1];
        for(int arr[] : dp){
            Arrays.fill(arr, -1);
        }
        return helper(0, -1, nums, dp);
    }
    public int helper(int ind, int prevInd, int[] nums, int[][] dp){
        if(ind == nums.length){
            return 0;
        }
        if(dp[ind][prevInd+1] != -1){
            return dp[ind][prevInd+1];
        }
        //not take
        int length = helper(ind+1, prevInd, nums, dp);
        //take
        if(prevInd == -1 || nums[ind] > nums[prevInd]){
            length = Math.max(length, 1 + helper(ind+1, ind, nums, dp));
        }
        return dp[ind][prevInd+1] = length;
    }
}