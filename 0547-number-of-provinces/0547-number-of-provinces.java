class Solution {
    public int findCircleNum(int[][] isConnected) {
        ArrayList<ArrayList<Integer>> adj= new ArrayList<>();
        int n=isConnected.length;
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(isConnected[i][j]==1 && i!=j){
                    adj.get(i).add(j);
                    adj.get(j).add(i);
                }
            }
        }
        int visited[]= new int[adj.size()];
        int count=0;
        for(int i=0;i<adj.size();i++){
            if(visited[i]==0){
                count++;
                dfs(i,adj,visited);
            }
        }

      return count;
    }
    public void dfs(int node, ArrayList<ArrayList<Integer>> adj,int[]visited){
        for(int i:adj.get(node)){
            if(visited[i]==0){
                visited[i]=1;
                dfs(i,adj,visited);
            }
        }
    }

}