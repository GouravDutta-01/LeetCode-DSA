// Question Link : https://leetcode.com/problems/wildcard-matching/

//Memoization Code
class Solution {
    public boolean isMatch(String s, String p) {
        int dp[][] = new int[s.length()][p.length()];
        for(int arr[] : dp){
            Arrays.fill(arr, -1);
        }
        return (helper(s.length()-1, p.length()-1, s, p, dp) == 1) ? true:false;   
    }
    public int helper(int i, int j, String s, String p, int dp[][]){
        if(i<0 && j<0){
            return 1;
        }
        else if(j<0 && i>=0){
            return 0;
        }
        else if(i<0 && j>=0){
            for(int k=0; k<=j; k++){
                if(p.charAt(k) != '*'){
                    return 0;
                }
            }
            return 1;
        }
        if(dp[i][j] != -1){
            return dp[i][j];
        }
        if(s.charAt(i) == p.charAt(j) || p.charAt(j) == '?'){
            return dp[i][j] = helper(i-1, j-1, s, p, dp);
        }
        if(p.charAt(j) == '*'){
            return dp[i][j] = helper(i, j-1, s, p, dp) | helper(i-1, j, s, p, dp);
        }
        return dp[i][j] = 0;
    }
}
