class Solution {
    public List<List<Integer>> permute(int[] nums) {
        int[] taken = new int[nums.length];
        List<List<Integer>> result=new ArrayList<>();
        List<Integer> ls=new ArrayList<>();
        helper(taken,result,ls,nums);
        return result;
    }
    public void helper(int[] taken, List<List<Integer>> result,List<Integer> ls,int[]nums) {
        if(ls.size()==nums.length){
            result.add(new ArrayList<>(ls));
            return;
        }
        for(int i=0;i<nums.length;i++){
            if(taken[i]==1)continue;
            taken[i]=1;
            ls.add(nums[i]);
            helper(taken,result,ls,nums);
            ls.remove(ls.size()-1);
            taken[i]=0;
        }

    }
}