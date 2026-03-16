class Solution {
    public static final String[] keypad={
        "","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"
    };
    public List<String> letterCombinations(String digits) {
        List<String> result=new ArrayList<>();
        if(digits.length()==0) return result;
        helper(digits,new StringBuilder(),result,0);
        return result;
    }
    public static void helper(String digits,StringBuilder ans,List<String> result,int index){
        if(index==digits.length()){
            result.add(ans.toString());
            return;
        }
        String letters=keypad[digits.charAt(index)-'0'];
        for(char ch:letters.toCharArray()){
            ans.append(ch);
            helper(digits,ans,result,index+1);
            ans.deleteCharAt(ans.length()-1);

        }
        
    }
}