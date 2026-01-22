class Solution {
    public int largestAltitude(int[] gain) {
        int diff=gain[0];
        int max=gain[0];
        for(int i=1;i<gain.length;i++){
            diff=diff+gain[i];
            max=Math.max(max,diff);
        }
        return max>0?max:0;
    }
}