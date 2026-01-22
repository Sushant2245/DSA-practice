class Solution {
    public int[] leftRightDifference(int[] nums) {
        int leftSum[]=new int[nums.length];
        int rightSum[]=new int[nums.length];
        int result[]=new int[nums.length];
        for(int i=1;i<nums.length;i++){
            leftSum[i]=nums[i-1]+leftSum[i-1];
        }
        for(int j=nums.length-2;j>=0;j--){
            rightSum[j]=nums[j+1]+rightSum[j+1];
        }
        for(int i=0;i<nums.length;i++){
            result[i]=Math.abs(leftSum[i]-rightSum[i]);
        }
        return result;
    }
}