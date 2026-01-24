class Solution {
    public int compress(char[] chars) {
        int i=0;
        int index=0;
        while(i<chars.length){
            int count=0;
            char ch=chars[i];
            while(i<chars.length && chars[i]==ch){
                count++;
                i++;
            }
            if(count==1)chars[index++]=ch;
            else{
                chars[index++]=ch;
                String str=Integer.toString(count);
                for(char dig:str.toCharArray()){
                    chars[index++]=dig;
                }
            }

        }
        return index;
    }
}