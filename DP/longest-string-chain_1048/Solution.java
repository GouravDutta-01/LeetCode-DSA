// Question Link : https://leetcode.com/problems/longest-string-chain/

//Tabulation Code
class Solution {
    public int longestStrChain(String[] words) {
        Arrays.sort(words, Comparator.comparing(s->s.length()));
        int dp[] = new int[words.length];
        Arrays.fill(dp, 1);
        int maxLen = 1;
        for(int i = 0; i<words.length; i++){
            for(int prev = 0; prev<i; prev++){
                if(checkPossible(words[i], words[prev])){
                    dp[i] = Math.max(dp[i], 1 + dp[prev]);
                }
            }
            maxLen = Math.max(maxLen, dp[i]);
        }
        return maxLen;   
    }
    public boolean checkPossible(String s1, String s2){
        if(s1.length() != s2.length() + 1){
            return false;
        }
        int first = 0;
        int second = 0;
        while(first < s1.length()){
            if(second == s2.length()){
                return true;
            }
            if(s1.charAt(first) == s2.charAt(second)){
                first++;
                second++;
            }
            else{
                first++;
            }
        }
        if(first == s1.length() && second == s2.length()){
            return true;
        }
        return false;
    }
}