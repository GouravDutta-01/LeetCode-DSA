// Question Link : https://leetcode.com/problems/minimum-operations-to-make-array-equal-ii/description/

class Solution {
    public long minOperations(int[] nums1, int[] nums2, int k) {
        if(k == 0){
            for(int i=0; i<nums1.length; i++){
                if(nums1[i] != nums2[i]){
                    return -1;
                }
            }
            return 0;
        }
        int temp = 0;
        long countOp = 0;
        for(int i=0; i<nums1.length; i++){
            int diff = nums1[i] - nums2[i];
            if(diff%k != 0){ //diff should be divisible by k for making nums1 and nums2 equal
                return -1;
            }
            if(diff > 0){ //as total additions and total subtractions of k are equal, we take the count of operations by counting the total additions of k required
                countOp += diff/k;
            }
            temp += diff;
        }
        if(temp != 0){ //total addition of k equals total subtraction of k making resultant zero.So if resultant is not zero then nums1 can't be equal to nums2
            return -1;
        }
        return countOp;  
    }
}