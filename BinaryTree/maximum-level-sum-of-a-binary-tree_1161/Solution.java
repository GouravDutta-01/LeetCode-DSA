// Question Link : https://leetcode.com/problems/maximum-level-sum-of-a-binary-tree/description/

class Solution {
    public int maxLevelSum(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        int lvl = 1;
        int maxSum = Integer.MIN_VALUE;
        int minLevel = -1;
        while(!q.isEmpty()){
            int levelSize = q.size();
            int levelSum = 0;
            for(int i=0; i<levelSize; i++){
                TreeNode currNode = q.poll();
                levelSum += currNode.val;
                if(currNode.left != null){
                    q.offer(currNode.left);
                }
                if(currNode.right != null){
                    q.offer(currNode.right);
                }
            }
            if(levelSum > maxSum){
                minLevel = lvl;
                maxSum = levelSum;
            }
            lvl++;
        }
        return minLevel;    
    }
}