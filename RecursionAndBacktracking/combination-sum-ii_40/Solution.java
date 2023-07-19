// Question Link : https://leetcode.com/problems/combination-sum-ii/

class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(candidates);
        combinationFind(0, target, candidates, new ArrayList<>(), ans);  
        return ans;
    }
    public void combinationFind(int ind, int target, int[] candidates, List<Integer> list, List<List<Integer>> ans){
        if(target == 0){
            ans.add(new ArrayList<>(list));    
        }
        for(int i=ind; i<candidates.length; i++){
            if(i > ind && candidates[i] == candidates[i-1]){
                continue;
            }
            if(candidates[i] > target){
                break;
            }
            list.add(candidates[i]);
            combinationFind(i+1, target-candidates[i], candidates, list, ans);
            list.remove(list.size()-1);
        }
    }
}