// Question Link : https://leetcode.com/problems/burst-balloons/

//Memoization Code
class Solution {
    public int maxCoins(int[] nums) {
        int dp[][] = new int[nums.length+1][nums.length+1];
        for(int val[] : dp){
            Arrays.fill(val, -1);
        }
        int arr[] = new int[nums.length+2];
        arr[0] = arr[nums.length+1] = 1;
        for(int i=1; i<nums.length+1; i++){
            arr[i] = nums[i-1];
        }
        return helper(1, nums.length, arr, dp);  
    }
    public int helper(int i, int j, int[] arr, int[][] dp){
        if(i > j){
            return 0;
        }
        if(dp[i][j] != -1){
            return dp[i][j];
        }
        int maxCoins = Integer.MIN_VALUE;
        for(int ind=i; ind<=j; ind++){
            int coins = arr[i-1]*arr[ind]*arr[j+1] + helper(i, ind-1, arr, dp) + helper(ind+1, j, arr, dp);
            maxCoins = Math.max(maxCoins, coins);
        }
        return dp[i][j] = maxCoins;
    }
}