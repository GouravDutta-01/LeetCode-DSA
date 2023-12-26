// Question Link : https://leetcode.com/problems/maximum-number-of-vowels-in-a-substring-of-given-length/description/

class Solution {
    public int maxVowels(String s, int k) {
        int left = 0, right = 0, result = 0, window = 0;
        for(; right<k; right++){
            if(isVowel(s.charAt(right))){
                window++;
            }
        }
        result = window;
        while(right < s.length()){
                if(isVowel(s.charAt(left++))){
                    window--;
                }
                if(isVowel(s.charAt(right++))){
                    window++;
                }
                result = Math.max(result, window);
            }
        return result;        
    }
    public boolean isVowel(char c){
        if(c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u'){
            return true;
        }
        return false;
    }
}