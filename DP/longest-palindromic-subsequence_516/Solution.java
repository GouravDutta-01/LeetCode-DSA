// Question Link : https://leetcode.com/problems/longest-palindromic-subsequence/

//Tabulation Code
class Solution {
    public int longestPalindromeSubseq(String s) {
        String revStr = new StringBuilder(s).reverse().toString();
        return longestCommonSubsequence(s, revStr);  
    }
    public int longestCommonSubsequence(String text1, String text2) {
        int dp[][] = new int[text1.length() + 1][text2.length() + 1];
        for(int ind1=0; ind1<=text1.length(); ind1++){
            for(int ind2=0; ind2<=text2.length(); ind2++){
                if(ind1==0 || ind2==0){
                    dp[ind1][ind2] = 0;
                }
                else if(text1.charAt(ind1-1) == text2.charAt(ind2-1)){
                    dp[ind1][ind2] = 1 + dp[ind1-1][ind2-1];
                }
                else{
                    dp[ind1][ind2] = Math.max(dp[ind1-1][ind2], dp[ind1][ind2-1]);
                }
            }
        }
        return dp[text1.length()][text2.length()];  
    }
}