class Solution {
    public int[] leftRightDifference(int[] nums) {
        if(nums.length==1)return new int[]{0};
        int result[]=new int[nums.length];
        for(int i=1;i<nums.length;i++){
            result[i]=nums[i-1]+result[i-1];
        }
        int suffix=nums[nums.length-1];
        for(int i=nums.length-2;i>=1;i--){
            result[i]=Math.abs(suffix-result[i]);
            suffix+=nums[i];
        }
        result[0]=suffix;
        return result;
    }
}