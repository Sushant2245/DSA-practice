class Solution {
    public String getHint(String secret, String guess) {
        Map<Character,Integer> map= new HashMap<>();
        int bulls=0;
        int cows=0;
        for(int i=0;i<secret.length();i++){
            if(secret.charAt(i)==guess.charAt(i)){
                bulls++;
            }
            else{
                map.put(secret.charAt(i),map.getOrDefault(secret.charAt(i),0)+1);
            }
        }
        for(int i=0;i<guess.length();i++){
            if(secret.charAt(i)!=guess.charAt(i)){
                char c= guess.charAt(i);
                if(map.containsKey(c)){
                    cows++;
                    map.put(c,map.getOrDefault(c,0)-1);
                    if(map.get(c)==0) map.remove(c);
                }
            }
        }
       
        return bulls+"A"+cows+"B";
    }
}