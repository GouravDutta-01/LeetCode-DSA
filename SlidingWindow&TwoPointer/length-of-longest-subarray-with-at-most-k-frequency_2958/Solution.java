// Question Link : https://leetcode.com/problems/length-of-longest-subarray-with-at-most-k-frequency/description/

class Solution {
    public int maxSubarrayLength(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int maxLen = Integer.MIN_VALUE;
        int left = 0;
        for(int right=0; right<nums.length; right++){
            map.put(nums[right], map.getOrDefault(nums[right], 0) + 1);
            while(map.get(nums[right]) > k){
                map.put(nums[left], map.get(nums[left])-1);
                left++;
            }
            maxLen = Math.max(maxLen, right-left+1);
        }
        return maxLen;   
    }
}