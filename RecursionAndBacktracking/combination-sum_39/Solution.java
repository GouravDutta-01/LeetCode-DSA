// Question Link : https://leetcode.com/problems/combination-sum/

class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        combinationFind(0, target, candidates, new ArrayList<>(), ans); 
        return ans;
    }
    public void combinationFind(int ind, int target, int[] candidates, List<Integer> list, List<List<Integer>> ans){
        if(ind == candidates.length){
            if(target == 0){
                ans.add(new ArrayList<>(list));
            }
            return;
        }
        if(candidates[ind] <= target){
            list.add(candidates[ind]);
            combinationFind(ind, target-candidates[ind], candidates, list, ans);
            list.remove(list.size()-1);
        }
        combinationFind(ind+1, target, candidates, list, ans);
    }
}