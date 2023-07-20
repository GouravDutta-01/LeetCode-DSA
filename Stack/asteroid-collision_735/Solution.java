// Question Link : https://leetcode.com/problems/asteroid-collision/

class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<>();
        for(int i=0; i<asteroids.length; i++){
            while(!stack.isEmpty() && asteroids[i]<0 && stack.peek()>0){
                int diff = stack.peek() + asteroids[i];
                if(diff > 0){//asteroid moving in negative direction explodes
                    asteroids[i] = 0;
                }
                else if(diff < 0){//asteroid moving in positive direction explodes
                    stack.pop();
                }
                else{//both asteroid of same size explodes
                    stack.pop();
                    asteroids[i] = 0;
                }
            }
            if(asteroids[i] != 0){
                stack.push(asteroids[i]);
            }
        }
        int ans[] = new int[stack.size()];
        int j = stack.size()-1;
        while(!stack.isEmpty()){
            ans[j--] = stack.pop();

        }
        return ans;    
    }
}