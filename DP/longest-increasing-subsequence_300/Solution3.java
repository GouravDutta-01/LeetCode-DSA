// Question Link : https://leetcode.com/problems/longest-increasing-subsequence/

//Tabulation Code
class Solution {
    public int lengthOfLIS(int[] nums) {
        int dp[] = new int[nums.length];
        Arrays.fill(dp, 1);
        int maxLen = 1;
        for(int i = 0; i<nums.length; i++){
            for(int prev = 0; prev<i; prev++){
                if(nums[prev] < nums[i]){
                    dp[i] = Math.max(dp[i], 1 + dp[prev]);
                }
            }
            maxLen = Math.max(maxLen, dp[i]);
        }
        return maxLen;    
    }
}