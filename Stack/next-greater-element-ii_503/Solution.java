// Question Link : https://leetcode.com/problems/next-greater-element-ii/

class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int ans[] = new int[nums.length];
        Arrays.fill(ans, -1);
        Stack<Integer> stk = new Stack<>();
        for(int i=2*nums.length-1; i>=0; i--){
            while(!stk.isEmpty() && nums[i%nums.length]>=stk.peek()){
                stk.pop();
            }
            if(i < nums.length){
                if(!stk.isEmpty()){
                    ans[i] = stk.peek();
                }
            }
            stk.push(nums[i%nums.length]);
        }
        return ans;  
    }
}