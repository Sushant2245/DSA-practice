class Solution {
    public int largestInteger(int num) {
        PriorityQueue<Integer> even= new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> odd= new PriorityQueue<>(Collections.reverseOrder());
        char[] digits =  String.valueOf(num).toCharArray();
        for(char c:digits){
            int d= c-'0';
            if(d%2==0)even.add(d);
            else odd.add(d);
        }
        StringBuilder sb= new StringBuilder();
        for(char c:digits){
            int d=c-'0';
            if(d%2==0){
                sb.append(even.poll());
            }
            else{
                sb.append(odd.poll());
            }
        }
        return Integer.parseInt(sb.toString());

        

    }
}