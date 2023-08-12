// Question Link : ttps://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/

class Solution {
    public int[] searchRange(int[] nums, int target) {
        int low = 0;
        int high = nums.length-1;
        int ans[] = {-1, -1};
        while(low <= high){
            int mid = (low+high)/2;
            if(nums[mid] == target){
                high = mid-1;
                ans[0] = mid;
            }
            else if(nums[mid] > target){
                high = mid-1;
            }
            else{
                low = mid+1;
            }
        }
        low = 0;
        high = nums.length-1;
        while(low <= high){
            int mid = (low+high)/2;
            if(nums[mid] == target){
                low = mid+1;
                ans[1] = mid;
            }
            else if(nums[mid] > target){
                high = mid-1;
            }
            else{
                low = mid+1;
            }
        }
        return ans;    
    }
}