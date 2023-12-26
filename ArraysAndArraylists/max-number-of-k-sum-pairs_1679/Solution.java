// Question Link : https://leetcode.com/problems/max-number-of-k-sum-pairs/description/

class Solution {
    public int maxOperations(int[] nums, int k) {
        Arrays.sort(nums);
        int count = 0;
        int left = 0;
        int right = nums.length-1;
        while(left < right){
            if(nums[left] + nums[right] == k){
                count++;
                left++;
                right--;
            }
            else if(nums[left] + nums[right] < k){
                left++;
            }
            else{
                right--;
            }
        }       
        return count;       
    }
}