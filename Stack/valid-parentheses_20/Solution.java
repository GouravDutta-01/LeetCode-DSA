// Question Link : https://leetcode.com/problems/valid-parentheses/

class Solution {
    public boolean isValid(String s) {
        Stack<Character> stk = new Stack<>();
        for(int i=0; i<s.length(); i++){
            if(s.charAt(i)=='[' || s.charAt(i)=='{' || s.charAt(i)=='('){
                stk.push(s.charAt(i));
            }
            else{
                if(stk.isEmpty()){
                    return false;
                }
                if((s.charAt(i)==']' && stk.pop()=='[') || (s.charAt(i)=='}' && stk.pop()=='{') || (s.charAt(i)==')' && stk.pop()=='(')){
                    continue;
                }
                else{
                    return false;
                }
            }
        }
        return stk.isEmpty();
    }
}