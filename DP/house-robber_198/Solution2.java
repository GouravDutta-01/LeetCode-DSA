// Question Link : https://leetcode.com/problems/house-robber/

//Space Optimised Code
class Solution {
    public int rob(int[] nums) {
        int prev = nums[0];
        int prev2 = 0;
        for(int i=1; i<nums.length; i++){
            int pick = nums[i];
            if(i>1){
                pick += prev2;
            }
            int notPick = prev;
            int curr = Math.max(pick, notPick);
            prev2 = prev;
            prev = curr;
        }
        return prev;
    }   
}