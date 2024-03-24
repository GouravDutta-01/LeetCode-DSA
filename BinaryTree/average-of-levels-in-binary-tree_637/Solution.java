// Question Link : https://leetcode.com/problems/average-of-levels-in-binary-tree/description/

class Solution {
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> ans = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while(!q.isEmpty()){
            int levelSize = q.size();
            double levelSum = 0;
            for(int i=0; i<levelSize; i++){
                TreeNode curr = q.poll();
                levelSum += curr.val;
                if(curr.left != null){
                    q.offer(curr.left);
                }
                if(curr.right != null){
                    q.offer(curr.right);
                }
            }
            ans.add(levelSum/levelSize);
        }
        return ans;     
    }
}