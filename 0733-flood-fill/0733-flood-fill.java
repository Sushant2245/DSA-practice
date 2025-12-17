class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int n= image.length;
        int m= image[0].length;
        int initial=image[sr][sc];
        if(initial==color) return image;
        dfs(image,sr,sc,color,initial,n,m);
        return image;

    }
    public void dfs(int[][] image, int sr, int sc, int color, int initial,int n,int m){
        if(sr<0 || sc<0 || sr>=n || sc>=m) return;
        if(image[sr][sc]!=initial) return ;
        image[sr][sc]= color;
         dfs(image,sr+1,sc,color,initial,n,m);
         dfs(image,sr-1,sc,color,initial,n,m);
         dfs(image,sr,sc+1,color,initial,n,m);
         dfs(image,sr,sc-1,color,initial,n,m);

    }
}