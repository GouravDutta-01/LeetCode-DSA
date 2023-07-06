// Question Link : https://leetcode.com/problems/course-schedule/

class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i=0; i<numCourses; i++){
            adj.add(new ArrayList<>());
        }
        for(int i=0; i<prerequisites.length; i++){
            adj.get(prerequisites[i][1]).add(prerequisites[i][0]);
        }
        int indegree[] = new int[numCourses];
        for(int i=0; i<numCourses; i++){
            for(int val : adj.get(i)){
                indegree[val]++;
            }
        }
        Queue<Integer> q = new LinkedList<>();
        for(int i=0; i<numCourses; i++){
            if(indegree[i] == 0){
                q.add(i);
            }
        }
        ArrayList<Integer> topo = new ArrayList<>();
        while(!q.isEmpty()){
            int curr = q.remove();
            topo.add(curr);
            for(int val : adj.get(curr)){
                indegree[val]--;
                if(indegree[val] == 0){
                    q.add(val);
                }
            }
        }
        return (topo.size() == numCourses);  
    }
}