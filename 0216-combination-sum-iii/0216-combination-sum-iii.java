class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> ans=new ArrayList<>();
        helper(k,n,ans,new ArrayList<>(),1);
        return ans;


    }
    public void helper(int k,int n,List<List<Integer>> ans,List<Integer> list,int start){
        if(k==0 && n==0){
            ans.add(new ArrayList<>(list));
            return;
        }
        if(k==0 || n<0)return;
        for(int i=start;i<=9;i++){
            list.add(i);
            helper(k-1,n-i,ans,list,i+1);
            list.remove(list.size()-1);
        }
    }
}