class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        if(hand.length%groupSize!=0)return false;
         Map<Integer, Integer> freq = new HashMap<>();
        for (int card : hand) {
            freq.put(card, freq.getOrDefault(card, 0) + 1);
        }
        PriorityQueue<Integer> heap=new PriorityQueue<>(freq.keySet());
        while(!heap.isEmpty()){
            int start=heap.peek();
            for(int i=0;i<groupSize;i++){
                int card=start+i;
                if(!freq.containsKey(card)) return false;
                freq.put(card,freq.getOrDefault(card,0)-1);
                if(freq.get(card)==0){
                    freq.remove(card);
                    if(heap.peek()==card){
                        heap.remove(card);
                    }
                }

            }
        }
        return true;
        
    }
}