// Question Link : https://leetcode.com/problems/minimum-absolute-difference-in-bst/

class Solution {
    int min = Integer.MAX_VALUE;
    int  prev = Integer.MAX_VALUE;
    public int getMinimumDifference(TreeNode root) {
        if(root == null){
            return min;
        }
        getMinimumDifference(root.left);
        min = Math.min(min, Math.abs(root.val - prev));
        prev = root.val;
        getMinimumDifference(root.right);
        return min;  
    }
}