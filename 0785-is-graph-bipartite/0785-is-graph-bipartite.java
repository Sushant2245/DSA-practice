class Solution {
    public boolean isBipartite(int[][] graph) {
        int n= graph.length;
        
        int color[]= new int[n];
        for(int i=0;i<color.length;i++)color[i]=-1;
        for(int i=0;i<n;i++){
            if(color[i]==-1){
                if(dfs(i,0,color,graph)==false)return false;
            }
        }
        return true;
    }
    public boolean dfs(int node,int col,int color[],int[][]graph){
        color[node]=col;
        for(Integer i:graph[node]){
            if(color[i]==-1){
                if(dfs(i,1-col,color,graph)==false) return false;
            }
            else if(color[i]==col) return false;
        }
        return true;
    }
}