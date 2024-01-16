// Question Link : https://leetcode.com/problems/find-players-with-zero-or-one-losses/description/

class Solution {
    public List<List<Integer>> findWinners(int[][] matches) {
        List<List<Integer>> ans = new ArrayList<>();
        ans.add(new ArrayList<>());
        ans.add(new ArrayList<>());
        HashMap<Integer, Integer> map = new HashMap<>();// key = players, value = no. of lost matches
        for(int i=0; i<matches.length; i++){ //initialize every player with zero loss
            map.put(matches[i][0], 0);
            map.put(matches[i][1], 0);
        }
        for(int i=0; i<matches.length; i++){
            int lostPlayer = matches[i][1];
            map.put(lostPlayer, map.get(lostPlayer) + 1);
        }
        for(Map.Entry<Integer, Integer> entry : map.entrySet()){
            if(entry.getValue() == 0){
                ans.get(0).add(entry.getKey());
            }
            else if(entry.getValue() == 1){
                ans.get(1).add(entry.getKey());
            }
        }
        Collections.sort(ans.get(0));
        Collections.sort(ans.get(1));
        return ans;  
    }
}