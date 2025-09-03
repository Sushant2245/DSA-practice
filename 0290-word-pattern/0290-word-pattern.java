class Solution {
    public boolean wordPattern(String pattern, String s) {
        HashMap<Character,String> map= new HashMap<>();
        HashMap<String, Character> reverseMap = new HashMap<>();
        String[] words = s.split(" ");
        if (pattern.length() != words.length) return false;

        int i=0;
        int j=0;
        while(i<pattern.length() && j<words.length){
            if(map.containsKey(pattern.charAt(i))){
                if(!map.get(pattern.charAt(i)).equals(words[j])){
                    return false;
                }
            }
            else{
                map.put(pattern.charAt(i),words[j]);
            }
             if (reverseMap.containsKey(words[i])) {
                if (reverseMap.get(words[i]) != pattern.charAt(i)) return false;
            } else {
                reverseMap.put(words[i], pattern.charAt(i));
            }
            i++;
            j++;
        }
        return true;
    }
}