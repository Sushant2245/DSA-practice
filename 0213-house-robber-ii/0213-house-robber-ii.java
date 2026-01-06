class Solution {
    public int rob(int[] nums) {
        int n=nums.length;
        if(n==1)return nums[0];
        int case1=fun(nums,0,n-2);
        int case2=fun(nums,1,n-1);
        return Math.max(case1,case2);
    }
    public int fun(int[] nums,int s,int e){
        int n=e-s+1;
        int dp[]=new int[n+1];
        dp[0]=nums[s];
        for(int i=1;i<n;i++){
            int take=nums[s+i];
            if(i>1){
                take+=dp[i-2];
            }
            int notTake=dp[i-1];
            dp[i]=Math.max(take,notTake);
        }
        return dp[n-1];
    }
}