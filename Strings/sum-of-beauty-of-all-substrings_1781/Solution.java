// Question Link : https://leetcode.com/problems/sum-of-beauty-of-all-substrings/description/

class Solution {
    public int beautySum(String s) {
        int sum = 0;
        for(int i=0; i<s.length(); i++){
            int[] freq = new int[26];
            for(int j=i; j<s.length(); j++){
                freq[s.charAt(j)-'a']++;
                sum += beauty(freq);
            }
        }
        return sum;  
    }
    public int beauty(int[] freq){
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for(int val : freq){
            max = Math.max(max, val);
            if(val != 0){
                min = Math.min(min, val);
            }
        }
        return (max-min);
    }
}