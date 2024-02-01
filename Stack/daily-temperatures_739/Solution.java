// Question Link : https://leetcode.com/problems/daily-temperatures/description/

class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        Deque<Integer> stack = new ArrayDeque<>();
        int[] ans = new int[n];
        ans[n-1] = 0;
        stack.push(n-1);
        for(int i=n-2; i>=0; i--){
            while(!stack.isEmpty() && temperatures[stack.peek()] <= temperatures[i]){
                stack.pop();
            }
            ans[i] = (stack.isEmpty()?0:stack.peek()-i);
            stack.push(i);
        }
        return ans;    
    }
}