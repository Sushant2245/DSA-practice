class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int s=0;
        int e=max(piles);
        while(s<=e){
            int mid=s+(e-s)/2;
            int total=helper(piles,mid);
            if(total<=h){
                e=mid-1;
            }
            else{
                s=mid+1;
            }
        }
        return s;
    }
    public int max(int [] piles){
        int ans=Integer.MIN_VALUE;
        for(int i=0;i<piles.length;i++){
            ans=Math.max(ans,piles[i]);
        }
        return ans;
    }
    public int helper(int[] piles,int k){
        int total=0;
        for(int i=0;i<piles.length;i++){
            total+=Math.ceil((double)piles[i]/k);
        }
        return total;
    }
}