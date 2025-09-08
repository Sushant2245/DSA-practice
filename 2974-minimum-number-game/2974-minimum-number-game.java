class Solution {
    public int[] numberGame(int[] nums) {
        PriorityQueue<Integer> heap = new PriorityQueue<>();
        int result[]= new int[nums.length];
        for(int i=0;i<nums.length;i++){
            heap.add(nums[i]);
        }
        int i=0;
        while(!heap.isEmpty()){
            int a= heap.poll();
            int b= heap.poll();
            result[i]=b;
            i++;
            result[i]=a;
            i++;
          
        }
        return result;
    }
}