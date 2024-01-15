// Question Link : https://leetcode.com/problems/3sum/description/

class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(nums);
        for(int i=0; i<nums.length; i++){
            if (i > 0 && nums[i] == nums[i - 1]) { //skip duplicates
                continue;
            }
            int reqSum = -nums[i];
            int left = i+1;
            int right = nums.length-1;
            while(left < right){
                if(nums[left] + nums[right] < reqSum){
                    left++;
                }
                else if(nums[left] + nums[right] > reqSum){ 
                    right--;
                }
                else{
                    ans.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    while (left < right && nums[left] == nums[left+1]) { //skip duplicates
                        left++;
                    }
                    while (left < right && nums[right] == nums[right-1]) { //skip duplicates
                        right--;
                    }
                    left++;
                    right--;
                }
            }
        }
        return ans;    
    }
}