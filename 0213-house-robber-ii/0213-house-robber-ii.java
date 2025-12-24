class Solution {
    public int rob(int[] nums) {
        
        int case1=f(nums,0,nums.length-2);
        int case2=f(nums,1,nums.length-1);
        return Math.max(case1,case2);
    }
    public int f(int [] nums,int start,int end){
        int n=end-start+1;
        int dp[]= new int[n+1];
        dp[0]=nums[start];
        for(int i=1;i<n;i++){
            int take=nums[start+i];
            if(i>1)take+=dp[i-2];
            int notTake=dp[i-1];
            dp[i]=Math.max(take,notTake);
        }
        return dp[n-1];
    }
}