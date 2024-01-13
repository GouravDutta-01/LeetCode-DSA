// Question Link : https://leetcode.com/problems/minimum-operations-to-make-array-equal/description/

class Solution {
    public int minOperations(int n) {
        int countOp = 0;
        int midVal = n;//the final value of each element of the required array
        for(int i=0; i<n/2; i++){
            countOp += (midVal - (2*i + 1));
        }
        return countOp;    
    }
}