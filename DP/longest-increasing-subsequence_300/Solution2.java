// Question Link : https://leetcode.com/problems/longest-increasing-subsequence/

//Tabulation Code
class Solution {
    public int lengthOfLIS(int[] nums) {
        int dp[][] = new int[nums.length+1][nums.length+1];
        for(int ind = nums.length-1; ind >= 0; ind--){
            for(int prevInd = ind-1; prevInd >= -1; prevInd--){
                int length = dp[ind+1][prevInd+1];
                if(prevInd == -1 || nums[ind] > nums[prevInd]){
                    length = Math.max(length, 1 + dp[ind+1][ind+1]);
                }
                dp[ind][prevInd+1] = length;
            }
        }
        return dp[0][0];  
    }
}