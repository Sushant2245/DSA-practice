class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> result=new ArrayList<>();
        List<Integer> current=new ArrayList<>();
        int[] taken= new int[nums.length];
        Arrays.sort(nums);
        helper(nums,taken,current,result);
        return result;
    }
    public void helper(int[] nums,int[] taken,  List<Integer> current,List<List<Integer>> result){
        if(current.size()==nums.length){
            result.add(new ArrayList<>(current));
            return;
        }
        for(int i=0;i<nums.length;i++){
            if(taken[i]==1) continue;
            if(i>0 && nums[i]==nums[i-1] &&taken[i-1]==0)continue;
            taken[i]=1;
            current.add(nums[i]);
            helper(nums,taken,current,result);
            current.remove(current.size()-1);
            taken[i]=0;
        }
    }
}