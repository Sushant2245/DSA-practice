class Solution {
    public int findMinimumOperations(String s1, String s2, String s3) {
        int i=0;
        if(s1.charAt(0)!=s2.charAt(0) || s1.charAt(0)!=s3.charAt(0)) return -1;
        while(i<s1.length() && i<s2.length() && i<s3.length() && s1.charAt(i)==s2.charAt(i) &&
        s1.charAt(i)==s3.charAt(i)){
            i++;
        }
        return (s1.length()-i)+(s2.length()-i)+(s3.length()-i);
    }
}