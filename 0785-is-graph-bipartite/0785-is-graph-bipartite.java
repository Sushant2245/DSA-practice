class Solution {
    public boolean isBipartite(int[][] graph) {
        int n= graph.length;
        ArrayList<ArrayList<Integer>> adj= new ArrayList<>();
        for(int i = 0; i < n; i++){
            adj.add(new ArrayList<>());
        }
        for(int i=0;i<n;i++){
            for(int j: graph[i]){
                adj.get(i).add(j);
                adj.get(j).add(i);
            }
        }
        int color[]= new int[n];
        for(int i=0;i<color.length;i++)color[i]=-1;
        for(int i=0;i<n;i++){
            if(color[i]==-1){
                if(dfs(i,0,color,adj)==false)return false;
            }
        }
        return true;
    }
    public boolean dfs(int node,int col,int color[],ArrayList<ArrayList<Integer>> adj){
        color[node]=col;
        for(Integer i:adj.get(node)){
            if(color[i]==-1){
                if(dfs(i,1-col,color,adj)==false) return false;
            }
            else if(color[i]==col) return false;
        }
        return true;
    }
}