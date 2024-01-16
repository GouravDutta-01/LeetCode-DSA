// Question Link : https://leetcode.com/problems/count-elements-with-maximum-frequency/description/

class Solution {
    public int maxFrequencyElements(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int maxFreq = Integer.MIN_VALUE;
        for(int val : nums){
            map.put(val, map.getOrDefault(val, 0)+1);
            maxFreq = Math.max(maxFreq, map.get(val));
        }
        int count = 0;
        for(Map.Entry<Integer, Integer> val : map.entrySet()){
            if(val.getValue() == maxFreq){
                count++;
            }
            
        }
        return count*maxFreq;    
    }
}