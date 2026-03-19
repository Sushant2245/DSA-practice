class Solution {
    public boolean isBipartite(int[][] graph) {
        int n=graph.length;
        int color[]=new int[n];
        Arrays.fill(color,-1);
        for(int i=0;i<n;i++){
            if(color[i]==-1){
                if(!dfs(graph,0,color,i))return false;
            }
        }
        return true;
    }
    public boolean dfs(int[][]graph,int col,int[]color,int node){
        color[node]=col;
        for(int i:graph[node]){
            if(color[i]==-1){
            if(dfs(graph,1-col,color,i))return true;
            }
            else if(color[i]==col)return false;
        }
        return true;
    }
}