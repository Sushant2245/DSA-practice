class Solution {
    public String[] findRelativeRanks(int[] score) {
        String[] ans= new String[score.length];
        HashMap<Integer,Integer> map= new HashMap<>();
        PriorityQueue<Integer> heap= new PriorityQueue<>(Collections.reverseOrder());
        for(int i=0;i<score.length;i++){
            heap.add(score[i]);
            map.put(score[i],i);
        }
       int rank=1;
       while(!heap.isEmpty()){
        int val= heap.poll();
        int index=map.get(val);
         if (rank == 1) ans[index] = "Gold Medal";
         else if (rank == 2) ans[index] = "Silver Medal";
         else if (rank == 3) ans[index] = "Bronze Medal";
         else{
            ans[index]=String.valueOf(rank);
         }
         rank++;
       }
       return ans;
    }
}