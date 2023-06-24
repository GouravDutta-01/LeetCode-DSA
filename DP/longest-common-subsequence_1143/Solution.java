// Question Link : https://leetcode.com/problems/longest-common-subsequence/

//Memoization Code
class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int dp[][] = new int[text1.length()][text2.length()];
        for(int[] val : dp){
            Arrays.fill(val, -1);
        }
        return helper(text1.length()-1, text2.length()-1, text1, text2, dp);
    }
    public int helper(int ind1, int ind2, String text1, String text2, int[][] dp){
        if(ind1<0 || ind2<0){
            return 0;
        }
        if(dp[ind1][ind2] != -1){
            return dp[ind1][ind2];
        }
        //match
        if(text1.charAt(ind1) == text2.charAt(ind2)){
            return dp[ind1][ind2] = 1 + helper(ind1-1, ind2-1, text1, text2, dp);
        }
        //not match
        return dp[ind1][ind2] = Math.max(helper(ind1-1, ind2,text1, text2, dp), helper(ind1, ind2-1, text1, text2, dp));
    }
}