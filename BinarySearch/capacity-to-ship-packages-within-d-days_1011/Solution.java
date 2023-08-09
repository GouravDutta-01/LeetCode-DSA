// Question Link : https://leetcode.com/problems/capacity-to-ship-packages-within-d-days/

class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int sum = 0;
        int maxWt = 0;
        for(int i=0; i<weights.length; i++){
            sum += weights[i];
            if(maxWt < weights[i]){
                maxWt = weights[i];
            }
        }
        int low = maxWt;
        int high = sum;
        while(low <= high){
            int mid = (low+high)/2;
            int daysReq = findDaysReq(mid, weights);
            if(daysReq <= days){
                high = mid-1;
            }
            else{
                low = mid+1;
            }
        }
        return low;   
    }
    public int findDaysReq(int capacity, int[] weights){
        int days = 1;
        int load = 0;
        for(int i=0; i<weights.length; i++){
            if(load + weights[i] > capacity){
                load = weights[i];
                days++;
            }
            else{
                load += weights[i];
            }
        }
        return days;
    }
}