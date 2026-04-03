class Solution {
    public int minDays(int[] bloomDay, int m, int k) {
        long val=(long)m*k;
        if(val>bloomDay.length)return -1;
        int s=min(bloomDay);
        int e=max(bloomDay);
        while(s<=e){
            int mid=s+(e-s)/2;
            if(possible(bloomDay,m,k,mid))e=mid-1;
            else{
                s=mid+1;
            }

        }
        return s;
    }
    public boolean possible(int[] bloomDay,int m,int k ,int days){
        int flowers=0;
        int total=0;
        for(int i=0;i<bloomDay.length;i++){
            if(days>=bloomDay[i])flowers++;
            else{
                total+=flowers/k;
                flowers=0;
            }
        }
        total+=flowers/k;
        if(total>=m)return true;
        return false;

    }






    public int max(int[] bloomDay){
        int ans=Integer.MIN_VALUE;
        for(int i=0;i<bloomDay.length;i++){
            ans=Math.max(ans,bloomDay[i]);
        }
        return ans;
    }
    public int min(int[] bloomDay){
        int ans=Integer.MAX_VALUE;
        for(int i=0;i<bloomDay.length;i++){
            ans=Math.min(ans,bloomDay[i]);
        }
        return ans;
    }
}