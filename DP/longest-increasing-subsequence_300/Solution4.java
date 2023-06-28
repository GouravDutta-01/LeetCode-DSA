// Question Link : https://leetcode.com/problems/longest-increasing-subsequence/

//Space Optimizaton Code
class Solution {
    public int lengthOfLIS(int[] nums) {
        int next[] = new int[nums.length+1];
        int curr[] = new int[nums.length+1];
        for(int ind = nums.length-1; ind >= 0; ind--){
            for(int prevInd = ind-1; prevInd >= -1; prevInd--){
                int length = next[prevInd+1];
                if(prevInd == -1 || nums[ind] > nums[prevInd]){
                    length = Math.max(length, 1 + next[ind+1]);
                }
                curr[prevInd+1] = length;
            }
            next = curr;
        }
        return next[0];  
    }
}