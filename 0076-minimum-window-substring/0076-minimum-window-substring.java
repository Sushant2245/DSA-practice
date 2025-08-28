class Solution {
    public String minWindow(String s, String t) {
        int l=0;
        int r=0;
        int start=0;
        int count=0;
        int minLen=Integer.MAX_VALUE;
        Map<Character,Integer> map= new HashMap<>();
        for(int i=0;i<t.length();i++){
            map.put(t.charAt(i),map.getOrDefault(t.charAt(i),0)+1);
        }
        while(r<s.length()){
            char c= s.charAt(r);
            if(map.containsKey(c)){
                map.put(c,map.getOrDefault(c,0)-1);
                if(map.get(c)==0)count++;
                while(count==map.size()){
                  if (r - l + 1 < minLen) {
    minLen = r - l + 1;
    start = l;
}
                    
                    char left=s.charAt(l);
                    if(map.containsKey(left)){
                        map.put(left,map.getOrDefault(left,0)+1);
                        if(map.get(left)>0)count--;
                    }
                    l++;


                }
            }
            r++;
        }
        return minLen==Integer.MAX_VALUE?"":s.substring(start,start+minLen);
    }
}