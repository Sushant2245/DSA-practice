class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        ArrayList<ArrayList<Integer>> adj= new ArrayList<>();
        for(int i=0;i<graph.length;i++){
            adj.add(new ArrayList<>());
        }
        for(int i=0;i<graph.length;i++){
            for(int j:graph[i]){
                adj.get(j).add(i);
            }
        }
        int inDegree[]= new int[graph.length];
        Queue<Integer> q= new LinkedList<>();
        for(int i=0;i<graph.length;i++){
            for(int it:adj.get(i)){
                inDegree[it]++;
            }
        }
        for(int i=0;i<inDegree.length;i++){
            if(inDegree[i]==0)q.offer(i);
        }
        List<Integer> result= new ArrayList<>();
        while(!q.isEmpty()){
            int node=q.poll();
            result.add(node);
            for(int i:adj.get(node)){
                inDegree[i]--;
                if(inDegree[i]==0)q.offer(i);
            }
        }
         Collections.sort(result);
         return result;
    }
}