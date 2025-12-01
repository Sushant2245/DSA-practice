class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int n=numCourses;
        ArrayList<ArrayList<Integer>>adj=new ArrayList<>();
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        for(int i=0;i<prerequisites.length;i++){
            int a=prerequisites[i][0];
            int b=prerequisites[i][1];
            adj.get(b).add(a);
        }
        //topo sort cycle detection
        int inDegree[]= new int[n];
        for(int i=0;i<n;i++){
            for(int it:adj.get(i)){
                inDegree[it]++;
            }
        }
        Queue<Integer> q= new LinkedList<>();
        for(int i=0;i<n;i++){
            if(inDegree[i]==0){
                q.offer(i);
            }
        }
        int topo[]= new int[n];
        int i=0;
        while(!q.isEmpty()){
            int node=q.poll();
            topo[i++]=node;
            for(int it:adj.get(node)){
                inDegree[it]--;
                if(inDegree[it]==0)q.offer(it);
            }
        }
        if(i==n)return topo;
        return new int[]{};


    }
}