// Question Link : https://leetcode.com/problems/count-subarrays-where-max-element-appears-at-least-k-times/description/

class Solution {
    public long countSubarrays(int[] nums, int k) {
        int n = nums.length;
        int maxi = 0;
        for(int val : nums){
            maxi = Math.max(maxi, val);
        }
        long count = 0;//count of subarrays where max element appears less than k times
        int left = 0;
        int countMax = 0;
        for(int right=0; right<n; right++){
            if(nums[right] == maxi){
                countMax++;
            }
            while(countMax >= k){
                if(nums[left] == maxi){
                    countMax--;
                }
                left++;
            }
            count += right-left+1;
        }
        return (long)n*(n+1)/2-count;        
    }
}