// Question Link : https://leetcode.com/problems/minimum-number-of-operations-to-make-arrays-similar/description/

class Solution {
    public long makeSimilar(int[] nums, int[] target) {
        Arrays.sort(nums);
        Arrays.sort(target);
        //we need to now seperate to even and odd numbers of nums and target arrays so that the difference between elements of nums and target is always divisible by 2
        ArrayList<Integer> evenNums = new ArrayList<>();
        ArrayList<Integer> oddNums = new ArrayList<>();
        ArrayList<Integer> evenTarget = new ArrayList<>();
        ArrayList<Integer> oddTarget = new ArrayList<>();
        for(int val : nums){
            if(val%2 == 0){
                evenNums.add(val);
            }
            else{
                oddNums.add(val);
            }
        }
        for(int val : target){
            if(val%2 == 0){
                evenTarget.add(val);
            }
            else{
                oddTarget.add(val);
            }
        }
        long countOp = 0;
        for(int i=0; i<evenNums.size(); i++){
            int diff = evenNums.get(i) - evenTarget.get(i);
            if(diff > 0){
                countOp += (diff/2);
            }
        }
        for(int i=0; i<oddNums.size(); i++){
            int diff = oddNums.get(i) - oddTarget.get(i);
            if(diff > 0){
                countOp += (diff/2);
            }
        }
        return countOp;
        
    }
}