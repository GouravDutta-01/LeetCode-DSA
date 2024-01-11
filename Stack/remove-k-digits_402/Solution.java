// Question Link : https://leetcode.com/problems/remove-k-digits/description/

class Solution {
    public String removeKdigits(String num, int k) {
        Stack<Character> stack = new Stack<>();
        if(k == num.length()){
            return "0";
        }
        int i = 0;
        while(i < num.length()){
            // we maintain to keep the smaller number on the top of the stack and remove the top if a smaller element comes
            while(k > 0 && !stack.isEmpty() && stack.peek() > num.charAt(i)){
                stack.pop();
                k--;
            }
            stack.push(num.charAt(i));
            i++;
        }
        // when some elements in the string are equal then k doesn't gets fully decremented so we remove elements till k becomes 0
        while(k > 0){
            stack.pop();
            k--;
        }
        StringBuilder sb = new StringBuilder();
        while(!stack.isEmpty()){
            sb.append(stack.pop());
        }
        sb.reverse();
        // remove all leading zeroes
        while(sb.length() > 1 && sb.charAt(0) == '0'){
            sb.deleteCharAt(0);
        }
        return sb.toString();    
    }
}