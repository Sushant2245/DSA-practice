class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<Integer> sublist= new ArrayList<>();
        List<List<Integer>> result= new ArrayList<>();
        helper(nums,sublist,0,result);
        return result;
    }
    public void helper(int[] arr,List<Integer>sublist,int index,List<List<Integer>> result){
        if(index>=arr.length){
            result.add(new ArrayList<>(sublist));
            return;
        }
        sublist.add(arr[index]);
        helper(arr,sublist,index+1,result);
        sublist.remove(sublist.size()-1);
        helper(arr,sublist,index+1,result);
    }
}