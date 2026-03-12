class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> ans= new ArrayList<>();
        helper(n,"",ans,0,0);
        return ans;

    }
    public void helper(int n,String curr,List<String> ans,int open,int close){
        if(curr.length()==2*n){
            ans.add(curr);
            return;
        }
        if(open<n){
            helper(n,curr+'(',ans,open+1,close);
        }
        if(close<open){
            helper(n,curr+')',ans,open,close+1);
        }

    }
}