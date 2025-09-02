class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String,List<String>>map =  new HashMap<>();
        for(String s: strs){
            int[] count= new int[26];
            for(int i=0;i<s.length();i++){
                count[s.charAt(i)-'a']++;
            }
            StringBuilder sb= new StringBuilder();
            for(int i=0;i<count.length;i++){
                if(count[i]>0){
                    sb.append((char)(i-'a')).append(count[i]);
                }
            }
            String key= sb.toString();
            map.putIfAbsent(key,new ArrayList<>());
            map.get(key).add(s);
        }
        return new ArrayList<>(map.values());
    }
}