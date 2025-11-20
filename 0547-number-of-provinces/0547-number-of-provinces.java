class Solution {
    public int findCircleNum(int[][] isConnected) {
        int n= isConnected.length;
       ArrayList<ArrayList<Integer>> adj= new ArrayList<>();
       for(int i=0;i<n;i++){
        adj.add(new ArrayList<>());
       }
       for(int i=0;i<n;i++){
        for(int j=0;j<n;j++){
            if(isConnected[i][j]==1 && i!=j){
                adj.get(i).add(j);
                
            }
        }
       }
       int visited[]=new int[n];
       int count=0;
       for(int i=0;i<n;i++){
        if(visited[i]==0){
            count++;
            dfs(i,visited,adj);
        }
       }
       return count;
    }
    public void dfs(int n,int[]visited,ArrayList<ArrayList<Integer>> adj){
        visited[n]=1;
        for(Integer i: adj.get(n)){
            if(visited[i]==0){
                dfs(i,visited,adj);
            }
        }

    }
}