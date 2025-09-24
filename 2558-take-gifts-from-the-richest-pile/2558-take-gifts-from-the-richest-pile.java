class Solution {
    public long pickGifts(int[] gifts, int k) {
        PriorityQueue<Integer> q= new PriorityQueue<>(Collections.reverseOrder());
        for(int n:gifts){
            q.add(n);
        }
        for(int i=0;i<k;i++){
            int val=q.poll();
            q.add((int)Math.sqrt(val));
        }
        int sum=0;
        while(!q.isEmpty()){
            sum+=q.poll();
        }
        return sum;
    }
}