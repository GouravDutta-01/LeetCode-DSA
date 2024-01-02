// Question Link : https://leetcode.com/problems/max-consecutive-ones/description/

class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int left = 0;
        int window = 0;
        int ans = -1;
        for(int right=0; right<nums.length; right++){
            window += nums[right];
            while(right-left+1 != window){
                window -= nums[left++];
            }
            ans = Math.max(ans, right-left+1);
        }
        return ans;    
    }
}