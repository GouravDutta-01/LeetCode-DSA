// Question Link : https://leetcode.com/problems/split-array-largest-sum/

class Solution {
    public int splitArray(int[] nums, int k) {
        if(k > nums.length){
            return -1;
        }
        int max = Integer.MIN_VALUE;
        int sum = 0;
        for(int i=0; i<nums.length; i++){
            sum += nums[i];
            if(max < nums[i]){
                max = nums[i];
            }
        }
        int low = max;
        int high = sum;
        while(low <= high){
            int mid = (low + high)/2;
            if(isPossible(mid, nums, k)){
                high = mid-1;
            }
            else{
                low = mid+1;
            }
        }
        return low;  
    }
    public boolean isPossible(int mid, int[] nums , int k){
        int countSubarrays = 1;
        int currSum = 0;
        for(int i=0; i<nums.length; i++){
            if(currSum + nums[i] <= mid){
                currSum += nums[i];
            }
            else{
                countSubarrays++;
                currSum = nums[i];
            }
        }
        return (countSubarrays <= k);
    }
}