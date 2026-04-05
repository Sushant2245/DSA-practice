class Solution {
    public String longestPalindrome(String s) {
        int ss=0;
        int e=0;
        int maxLen=Integer.MIN_VALUE;
        for(int i=0;i<s.length();i++){
            int len1=helper(s,i,i);
            int len2=helper(s,i,i+1);
            maxLen=Math.max(len1,len2);
            if(maxLen>e-ss){
                ss=i-(maxLen-1)/2;
                e=i+maxLen/2;
            }
        }
        return(s.substring(ss,e+1));
    }
    public int helper(String s,int left,int right){
        while(left>=0 && right<s.length() && s.charAt(left)==s.charAt(right)){
            left--;
            right++;
        }
        return right-left-1;
    }

}