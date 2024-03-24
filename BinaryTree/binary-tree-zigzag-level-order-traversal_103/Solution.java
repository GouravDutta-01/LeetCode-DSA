// Question Link : https://leetcode.com/problems/binary-tree-zigzag-level-order-traversal/description/

class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if(root == null){
            return ans;
        }
        Deque<TreeNode> dq = new LinkedList<>();
        dq.offer(root);
        boolean reverse = false;
        while(!dq.isEmpty()){
            List<Integer> currLevel = new ArrayList<>();
            int levelSize = dq.size();
            for(int i=0; i<levelSize; i++){
                if(!reverse){
                    TreeNode currNode = dq.poll();
                    currLevel.add(currNode.val);
                    if(currNode.left != null){
                        dq.offer(currNode.left);
                    }
                    if(currNode.right != null){
                        dq.offer(currNode.right);
                    }
                }
                else{
                    TreeNode currNode = dq.pollLast();
                    currLevel.add(currNode.val);
                    if(currNode.right != null){
                        dq.offerFirst(currNode.right);
                    }
                    if(currNode.left != null){
                        dq.offerFirst(currNode.left);
                    }
                }
            }
            reverse = !reverse;
            ans.add(currLevel);
        }
        return ans;    
    }
}