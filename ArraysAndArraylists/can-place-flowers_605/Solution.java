// Question Link : https://leetcode.com/problems/can-place-flowers/description/

class Solution {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int count = 0;
        for(int i=0; i<flowerbed.length && count<n; i++){
            if(flowerbed[i] == 0){
                int prev = (i != 0 ? flowerbed[i-1] : 0);
                int next = (i != flowerbed.length-1 ? flowerbed[i+1] : 0);
                if(prev == 0 && next == 0){
                    flowerbed[i] = 1;
                    count++;
                }
            }
        }
        return (count == n);        
    }
}