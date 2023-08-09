// Question Link : https://leetcode.com/problems/minimize-the-maximum-difference-of-pairs/

class Solution {
    public int minimizeMax(int[] nums, int p) {
        Arrays.sort(nums);
        int low = 0;
        int high = nums[nums.length-1] - nums[0];
        while(low <= high){
            int mid = (low+high)/2;
            if(isPossible(mid, nums, p)){
                high = mid-1;
            }
            else{
                low = mid+1;
            }
        }
        return low;    
    }
    public boolean isPossible(int mid, int[] nums, int p){
        int countPairs = 0;
        int i = 0;
        while(i < nums.length-1){
            if(nums[i+1] - nums[i] <= mid){
                countPairs++;
                i += 2;
            }
            else{
                i++;
            }
        }
        if(countPairs >= p){
            return true;
        }
        return false;

    }
}