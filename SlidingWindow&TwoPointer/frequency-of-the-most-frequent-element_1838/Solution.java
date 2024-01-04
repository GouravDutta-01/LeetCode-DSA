// Question Link : https://leetcode.com/problems/frequency-of-the-most-frequent-element/description/

class Solution {
    public int maxFrequency(int[] nums, int k) {
        Arrays.sort(nums);
        long sum = 0;
        int ans = 0;
        int left = 0;
        for(int right=0; right<nums.length; right++){
            sum += nums[right]; 
            while(sum + k < (long)(right-left+1)*nums[right]){ 
                sum -= nums[left++];
            }
            ans = Math.max(ans, right-left+1); 
        } 
        return ans;     
    }
}