class Solution {
    public int leastInterval(char[] tasks, int n) {
       int freq[]= new int[26];
       for(char t:tasks){
        freq[t-'A']++;
       }
       PriorityQueue<Integer> maxHeap= new PriorityQueue<>(Collections.reverseOrder());
       for(int t:freq){
        if(t>0)maxHeap.add(t);
       }
       int time=0;
       while(!maxHeap.isEmpty()){
          int cycle=n+1;
          List<Integer> temp= new ArrayList<>();
          while(cycle>0 && !maxHeap.isEmpty()){
              int current= maxHeap.poll();
              if(current>1)temp.add(current-1);
              time++;
              cycle--;
          }
          for(int rem:temp){
            maxHeap.add(rem);
          }
          if(!maxHeap.isEmpty()){
            time+=cycle;
          }
       }
       return time;
    }
}