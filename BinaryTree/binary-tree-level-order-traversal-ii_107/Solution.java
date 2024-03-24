// Question Link : https://leetcode.com/problems/binary-tree-level-order-traversal-ii/description/

class Solution {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if(root == null){
            return ans;
        } 
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while(!q.isEmpty()){
            List<Integer> currLevel = new ArrayList<>();
            int levelSize = q.size();
            for(int i=0; i<levelSize; i++){
                TreeNode currNode = q.poll();
                currLevel.add(currNode.val);
                if(currNode.left != null){
                    q.offer(currNode.left);
                }
                if(currNode.right != null){
                    q.offer(currNode.right);
                }
            }
            ans.add(0, currLevel);
        }
        return ans;
    }
}