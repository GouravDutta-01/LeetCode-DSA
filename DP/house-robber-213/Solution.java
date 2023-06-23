// Question Link : https://leetcode.com/problems/house-robber-ii/

//Space Optimised Code
class Solution {
    public int rob(int[] nums) {
        if(nums.length == 1){
            return nums[0];
        }
        int prev = nums[0];
        int prev2 = 0;
        for(int i=1; i<nums.length-1; i++){
            int pick = nums[i];
            if(i>1){
                pick += prev2;
            }
            int notPick = prev;
            int curr = Math.max(pick, notPick);
            prev2 = prev;
            prev = curr;
        }
        int ans1 = prev;//max amount excluding end index
        int prev3 = nums[1];
        int prev4 = 0;
        for(int i=2; i<nums.length; i++){
            int pick = nums[i];
            if(i>1){
                pick += prev4;
            }
            int notPick = prev3;
            int curr2 = Math.max(pick, notPick);
            prev4 = prev3;
            prev3 = curr2;
        }
        int ans2 = prev3;//max amount excluding start index 
        return Math.max(ans1, ans2);      
    }
}