// Question Link : https://leetcode.com/problems/binary-tree-paths/

class Solution {
    public List<String> binaryTreePaths(TreeNode root) {
        String s = "";
        List path = new ArrayList<>();
        return rootToLeaf(path, root, s);
        
    }
    public List<String> rootToLeaf(List path, TreeNode root, String s){
        if(root == null){
            return path;
        }
        if(root.left == null && root.right == null){
            path.add(s + root.val);
        }
        s = s + root.val + "->";
        rootToLeaf(path, root.left, s);
        rootToLeaf(path, root.right, s);
        return path;
    }
}