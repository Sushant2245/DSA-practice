class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans= new ArrayList<>();
        helper(candidates,target,ans,new ArrayList<>(),0);
        return ans;
    }
    public void helper(int arr[],int target,List<List<Integer>> ans,List<Integer> curr,int index){
        if(index==arr.length){
            if(target==0){
                ans.add(new ArrayList<>(curr));
            }
            return;
        }
        if(arr[index]<=target){
            curr.add(arr[index]);
            helper(arr,target-arr[index],ans,curr,index);
            curr.remove(curr.size()-1);
        }
        helper(arr,target,ans,curr,index+1);
    }
}