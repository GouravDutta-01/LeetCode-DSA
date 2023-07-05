// Question Link : https://leetcode.com/problems/symmetric-tree/

class Solution {
    public boolean isSymmetric(TreeNode root) {
        if(root == null){
            return true;
        }
        return isMirror(root.left, root.right);  
    }
    public boolean isMirror(TreeNode leftRoot, TreeNode rightRoot){
        if(leftRoot == null && rightRoot == null){
            return true;
        }
        if(leftRoot == null || rightRoot == null){
            return false;
        }
        if(leftRoot.val != rightRoot.val){
            return false;
        }
        return isMirror(leftRoot.left, rightRoot.right) && isMirror(leftRoot.right, rightRoot.left);
    }
}