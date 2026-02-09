class Solution {
    public long minimumSteps(String s) {
        long ones=0;
        long count=0;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='1')ones++;
            else{
                count+=ones;
            }
        }
        return count;
    }
}