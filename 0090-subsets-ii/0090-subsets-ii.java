class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<Integer> sublist= new ArrayList<>();
        List<List<Integer>> result= new ArrayList<>();
        Arrays.sort(nums);
        helper(nums,sublist,0,result);
        return result;
    }
    public void helper(int[] arr,List<Integer>sublist,int index,List<List<Integer>> result){
        
            result.add(new ArrayList<>(sublist));
           
        for(int i=index; i<arr.length;i++){
            if(index<i && arr[i]==arr[i-1])continue;
            sublist.add(arr[i]);
            helper(arr,sublist,i+1,result);
            sublist.remove(sublist.size()-1);
        }
    }
}