class Solution {
    public int pivotIndex(int[] nums) {
        int prefix[]=new int[nums.length];
        int suffix[]=new int[nums.length];
        for(int i=1;i<nums.length;i++){
            prefix[i]=prefix[i-1]+nums[i-1];
        }
        for(int i=nums.length-2;i>=0;i--){
            suffix[i]=suffix[i+1]+nums[i+1];
        }
        for(int i=0;i<suffix.length;i++){
            
            if(suffix[i]==prefix[i])return i;
        }
        return -1;
    }
}