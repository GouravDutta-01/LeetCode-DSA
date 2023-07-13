// Question Link : https://leetcode.com/problems/minimum-cost-to-cut-a-stick/

//Memoization Code
class Solution {
    public int minCost(int n, int[] cuts) {
        int[] cuts1 = new int[cuts.length + 2];
        for(int i=0; i<cuts.length; i++){
            cuts1[i] = cuts[i];
        }
        cuts1[cuts.length] = 0;
        cuts1[cuts.length+1] = n;
        Arrays.sort(cuts1);
        int dp[][] = new int[cuts.length + 1][cuts.length + 1];
        for(int val[] : dp){
            Arrays.fill(val, -1);
        }
        return helper(1, cuts.length, cuts1, dp); 
    }
    public int helper(int i, int j, int[] cuts, int[][] dp){
        if(i > j){
            return 0;
        }
        if(dp[i][j] != -1){
            return dp[i][j];
        }
        int minCost = Integer.MAX_VALUE;
        for(int k=i; k<=j; k++){
            int cost = cuts[j+1] - cuts[i-1] + helper(i, k-1, cuts, dp) + helper(k+1, j, cuts, dp);
            minCost = Math.min(cost, minCost);
        }
        return dp[i][j] = minCost;
    }
}