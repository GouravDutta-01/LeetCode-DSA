// Question Link : https://leetcode.com/problems/min-stack/description/

class MinStack {
    Stack<Integer> stack = new Stack<>();
    Stack<Integer> stackMinVal = new Stack<>();//this stack keep track of min values that goes in the main stack

    public MinStack() {    
    }
    
    public void push(int val) {
        if(stackMinVal.isEmpty() || stackMinVal.peek() >= val){
            stackMinVal.push(val);
        }
        stack.push(val);    
    }
    
    public void pop() {
        if(stack.peek().equals(stackMinVal.peek())){//Stack stores Integer values and not int values. Since Integer values are objects you must use .equals() and not "==" to compare them
            stackMinVal.pop();
        }
        stack.pop();    
    }
    
    public int top() {
        return stack.peek();    
    }
    
    public int getMin() {
        return stackMinVal.peek();    
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */