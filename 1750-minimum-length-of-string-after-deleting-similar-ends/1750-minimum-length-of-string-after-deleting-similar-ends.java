class Solution {
    public int minimumLength(String s) {
       int l=0;
       int r=s.length()-1;
       while(l<r){
        if(s.charAt(l)==s.charAt(r)){
            l++;
            r--;
            while( l<s.length() && s.charAt(l)==s.charAt(l-1))l++;
            while(r>0 && s.charAt(r)==s.charAt(r+1))r--;
        }
        else{
           return r-l+1;

        }
       }
       return l==r?r-l+1:0;
    }
}