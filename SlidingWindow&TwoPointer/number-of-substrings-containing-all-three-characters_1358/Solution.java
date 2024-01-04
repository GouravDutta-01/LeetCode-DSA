// Question Link : https://leetcode.com/problems/number-of-substrings-containing-all-three-characters/description/

class Solution {
    public int numberOfSubstrings(String s) {
        int flagA = 0;
        int flagB = 0;
        int flagC = 0;
        int left = 0;
        int ans = 0;
        for(int right=0; right<s.length(); right++){
            if(s.charAt(right) == 'a'){
                flagA++;
            }
            else if(s.charAt(right) == 'b'){
                flagB++;
            }
            else if(s.charAt(right) == 'c'){
                flagC++;
            }
            while(flagA >= 1 && flagB >= 1 && flagC >= 1){
                if(s.charAt(left) == 'a'){
                    flagA--;
                }
                else if(s.charAt(left) == 'b'){
                    flagB--;
                }
                else if(s.charAt(left) == 'c'){
                    flagC--;
                }
                left++;
                ans += s.length()-right;
            }   
        } 
        return ans;   
    }
}