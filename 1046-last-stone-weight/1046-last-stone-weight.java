class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> heap= new PriorityQueue<>(Collections.reverseOrder());
        for(int n:stones){
            heap.add(n);
        }
        while(heap.size()>1){
            int y=heap.poll();
            int x=heap.poll();
            if(x==y) continue;
            else{
                heap.add(y-x);
            }
        }
        return heap.isEmpty()?0:heap.poll();
    }
}