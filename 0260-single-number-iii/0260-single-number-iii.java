class Solution {
    public int[] singleNumber(int[] nums) {
        int Xorr=0;
        for(int i=0;i<nums.length;i++){
            Xorr^=nums[i];
        }
        int rightMost= (Xorr & Xorr-1)^Xorr;
        int b1=0;
        int b2=0;
        for(int i=0;i<nums.length;i++){
            if((nums[i] & rightMost)==0){
                b1=b1^nums[i];
            }
            else{
                b2=b2^nums[i];
            }
        }
        return new int[]{b1,b2};
    }
}