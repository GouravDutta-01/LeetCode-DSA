// Question Link : https://leetcode.com/problems/delete-node-in-a-bst/description/

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public TreeNode deleteNode(TreeNode root, int key) {
        if(root == null){
            return root;
        }
        if(root.val > key){
            root.left = deleteNode(root.left, key);
        }
        else if(root.val < key){
            root.right = deleteNode(root.right, key);
        }
        else{
            //case1 : leaf node
            if(root.left == null && root.right == null){ 
                return null;
            }
            //case2 : node with one child
            if(root.left == null){
                return root.right;
            }
            else if(root.right == null){
                return root.left;
            }
            //case3 : node with two children
            TreeNode IS = findInorderSuccessor(root.right, key);
            root.val = IS.val;
            root.right = deleteNode(root.right, IS.val);
        }     
        return root;
    }
    public TreeNode findInorderSuccessor(TreeNode root, int key) {
        while(root.left != null){
            root = root.left;
        }
        return root;
    }
}