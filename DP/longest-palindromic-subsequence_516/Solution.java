// Question Link : https://leetcode.com/problems/longest-palindromic-subsequence/

//Tabulation Code
class Solution {
    public int longestPalindromeSubseq(String s) {
        String revS = new StringBuilder(s).reverse().toString();
        return lcs(s, revS);  
    }
    public int lcs(String a, String b){
        int m = a.length();
        int n = b.length();
        int[][] dp = new int[m+1][n+1];
        for(int i=1; i<m+1; i++){
            for(int j=1; j<n+1; j++){
                if(a.charAt(i-1) == b.charAt(j-1)){
                    dp[i][j] = 1 + dp[i-1][j-1];
                }
                else{
                    dp[i][j] = Math.max(dp[i][j-1], dp[i-1][j]);
                }
            }
        }
        return dp[m][n];
    }
}