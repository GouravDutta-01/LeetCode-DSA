// Question Link : https://leetcode.com/problems/minimum-number-of-days-to-make-m-bouquets/

class Solution {
    public int minDays(int[] bloomDay, int m, int k) {
        if(bloomDay.length < (long)m*(long)k){
            return -1;
        }
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for(int i=0; i<bloomDay.length; i++){
            if(bloomDay[i] > max){
                max = bloomDay[i];
            }
            if(bloomDay[i] < min){
                min = bloomDay[i];
            }
        }
        int low = min;
        int high = max;
        while(low <= high){
            int mid = (low+high)/2;
            if(isPossible(mid, m, k, bloomDay)){
                high = mid-1;
            }
            else{
                low = mid+1;
            }
        }
        return low;   
    }
    public boolean isPossible(int day, int m, int k, int[] bloomDay){
        int count = 0;
        int noOfBouquet = 0;
        for(int i=0; i<bloomDay.length; i++){
            if(bloomDay[i] <= day){
                count++;
            }
            else{
                noOfBouquet += (count/k);
                count = 0;
            }
        }
        noOfBouquet += (count/k);
        return (noOfBouquet >= m);
    }
}