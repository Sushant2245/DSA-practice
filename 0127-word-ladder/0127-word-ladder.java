class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Queue<Pair> q= new LinkedList<>();
        Set<String> set= new HashSet<>(wordList);
        if(!set.contains(endWord))return 0;
        q.offer(new Pair(beginWord,1));
        set.remove(beginWord);
        while(!q.isEmpty()){
            String word=q.peek().word;
            int level=q.peek().level;
            q.poll();
            if(word.equals(endWord)==true)return level;

            for(int i=0;i<word.length();i++){
                for(char ch='a';ch<='z';ch++){
                  char[]  wordArray=word.toCharArray();
                  wordArray[i]=ch;
                  String newWord=new String(wordArray);
                  if(set.contains(newWord)){
                    set.remove(newWord);
                    q.add(new Pair(newWord,level+1));
                  }
                }
            }
        }
        return 0;
    }

}
class Pair{
    String word;
    int level;
    public Pair(String word,int level){
        this.word=word;
        this.level=level;
    }
}