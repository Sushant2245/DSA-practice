class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int n=prerequisites.length;
        ArrayList<ArrayList<Integer>> adj= new ArrayList<>();
        for(int i=0;i<numCourses;i++){
            adj.add(new ArrayList<>());
        }
        for(int[] e: prerequisites){
            int u=e[0];
            int v=e[1];
            adj.get(u).add(v);
        }
        Queue<Integer> q= new LinkedList<>();
        int inDegree[]=new int[numCourses];
        for(int i=0;i<numCourses;i++){
            for(int it:adj.get(i)){
                inDegree[it]++;
            }
        }
        for(int i=0;i<numCourses;i++){
            if(inDegree[i]==0)q.offer(i);
        }
        ArrayList<Integer> topo=new ArrayList<>();
        while(!q.isEmpty()){
            int current=q.poll();
            topo.add(current);
            for(int it:adj.get(current)){
                inDegree[it]--;
                if(inDegree[it]==0)q.offer(it);
            }
        }
        if(topo.size()==numCourses)return true;
        return false;
    }
}