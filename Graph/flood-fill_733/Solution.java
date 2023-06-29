// Question Link : https://leetcode.com/problems/flood-fill/

class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int[][] ans = image;
        int initialCol = image[sr][sc];
        if(initialCol != color){
            dfs(ans, sr, sc, color, initialCol);
        }
        return ans;  
    }
    public void dfs(int[][] image, int sr, int sc, int color, int initialCol){
        if(sr<0 || sc<0 || sr>=image.length || sc>=image[0].length || image[sr][sc] != initialCol){
            return;
        }
        image[sr][sc] = color;
        dfs(image, sr, sc-1, color, initialCol);//left
        dfs(image, sr, sc+1, color, initialCol);//right
        dfs(image, sr-1, sc, color, initialCol);//up
        dfs(image, sr+1, sc, color, initialCol);//down
    }
}