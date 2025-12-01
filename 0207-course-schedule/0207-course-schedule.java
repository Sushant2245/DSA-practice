class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        ArrayList<ArrayList<Integer>> adj= new ArrayList<>();
        int n=numCourses;
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        for (int i = 0; i < prerequisites.length; i++) {
           int a = prerequisites[i][0];
           int b = prerequisites[i][1];
            adj.get(b).add(a);
        }
        //detect cycle using topo sort
        int inDegree[]= new int[n];
        for(int i=0;i<n ;i++){
            for(int it:adj.get(i)){
                inDegree[it]++;
            }
        }
        Queue<Integer> q= new LinkedList<>();
        for(int i=0;i<inDegree.length;i++){
            if(inDegree[i]==0){
                q.offer(i);
            }
        }
       List<Integer> topo= new ArrayList<>();
       while(!q.isEmpty()){
        int node= q.poll();
        topo.add(node);
         for(int it: adj.get(node)){
            inDegree[it]--;
            if(inDegree[it]==0)q.offer(it);
         }
       }
       return topo.size()==n;
    }
}