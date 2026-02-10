class Solution {
    public long[] findPrefixScore(int[] nums) {
        long [] result=new long[nums.length];
        int max=0;
        for(int i=0;i<nums.length;i++){
            max=Math.max(max,nums[i]);
            nums[i]=nums[i]+max;
        }
        result[0]=nums[0];
        for(int i=1;i<nums.length;i++){
            result[i]=result[i-1]+nums[i];
        }
        return result;
    }
}