class Solution {
    public List<List<Integer>> permute(int[] nums) {
        int taken[]=new int[nums.length];
        List<List<Integer>> ans= new ArrayList<>();
        List<Integer> ls=new ArrayList<>();
        helper(taken,ans,ls,nums);
        return ans;

    }
    public void helper(int[] taken, List<List<Integer>> ans,List<Integer> ls,int[] nums){
        if(ls.size()==nums.length){
            ans.add(new ArrayList<>(ls));
            return;
        }
       for(int i=0;i<nums.length;i++){
        if(taken[i]==1)continue;
        taken[i]=1;
        ls.add(nums[i]);
        helper(taken,ans,ls,nums);
        ls.remove(ls.size()-1);
        taken[i]=0;

       }

    }
}