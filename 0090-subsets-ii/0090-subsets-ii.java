class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> result= new ArrayList<>();
        List<Integer> ls=new ArrayList<>();
        Arrays.sort(nums);
        helper(nums,0,result,ls);
        return result;

    }
    public void helper(int[] nums,int index,List<List<Integer>> result,List<Integer> ls ){
        result.add(new ArrayList<>(ls));
        for(int i=index;i<nums.length;i++){
            if(i>index && nums[i]==nums[i-1])continue;
            ls.add(nums[i]);
            helper(nums,i+1,result,ls);
            ls.remove(ls.size()-1);
        }
    }
}