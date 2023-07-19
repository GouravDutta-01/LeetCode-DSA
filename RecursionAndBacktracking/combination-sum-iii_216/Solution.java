// Question Link : https://leetcode.com/problems/combination-sum-iii/

class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> ans = new ArrayList<>();
        combinationFind(1, n, k, new ArrayList<>(), ans);
        return ans;  
    }
    public void combinationFind(int ind, int n, int k, List<Integer> list, List<List<Integer>> ans){
        if(n == 0 && k == 0){
            ans.add(new ArrayList<>(list));
        }
        if(n <= 0){
            return;
        }
        for(int i=ind; i<=9; i++){
            list.add(i);
            combinationFind(i+1, n-i, k-1, list, ans);
            list.remove(list.size()-1);
        }
    }
}