class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int m=image.length;
        int n=image[0].length;
        int initial = image[sr][sc];
        if(initial==color)return image;
        dfs(image,sr,sc,m,n,color,initial);
        return image;

    }
    public void dfs(int[][]image,int sr,int sc,int m, int n,int color,int initial){
        if(sr<0 || sr>=m || sc<0 || sc>=n) return;
        if(image[sr][sc]!=initial)return;
        image[sr][sc]=color;
        dfs(image,sr+1,sc,m,n,color,initial);
        dfs(image,sr-1,sc,m,n,color,initial);
        dfs(image,sr,sc+1,m,n,color,initial);
        dfs(image,sr,sc-1,m,n,color,initial);


    }
}