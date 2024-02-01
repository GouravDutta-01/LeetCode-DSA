// Question Link : https://leetcode.com/problems/evaluate-reverse-polish-notation/description/

class Solution {
    public int evalRPN(String[] tokens) {
        Deque<Integer> stack = new ArrayDeque<>();
        for(String element : tokens){
            if(element.equals("+") || element.equals("-") || element.equals("*") || element.equals("/")){
                int operand2 = stack.pop();
                int operand1 = stack.pop();
                int value = calculate(element, operand1, operand2);
                stack.push(value);
            }
            else{
                stack.push(Integer.valueOf(element));
            }
        }
        return stack.pop();   
    }
    public int calculate(String operator, int a, int b){
        if(operator.equals("+")){
            return a + b;
        }
        else if(operator.equals("-")){
            return a-b;
        }
        else if(operator.equals("*")){
            return a*b;
        }
        else{
            return a/b;
        }
    }
}