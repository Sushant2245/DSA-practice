class Solution {
    public int maxProduct(int[] nums) {
        PriorityQueue<Integer> pq= new PriorityQueue<>(Collections.reverseOrder());
        for(int n: nums){
            pq.add(n);
        }
        int x=pq.poll()-1;
        int y=pq.poll()-1;
        return x*y;
        
    }
}