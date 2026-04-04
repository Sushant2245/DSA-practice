class Solution {
    public List<List<Integer>> permute(int[] nums) {
        int taken[]=new int[nums.length];
        List<List<Integer>> result=new ArrayList<>();
        List<Integer> current=new ArrayList<>();
        helper(nums,taken,result,current);
        return result;
    }
    public void helper(int[] nums,int[] taken, List<List<Integer>> result, List<Integer> current){
        if(current.size()==nums.length){
            result.add(new ArrayList<>(current));
            return;
        }
        for(int i=0;i<nums.length;i++){
            if(taken[i]==1)continue;
            taken[i]=1;
            current.add(nums[i]);
            helper(nums,taken,result,current);
            current.remove(current.size()-1);
            taken[i]=0;

        }
    }
}