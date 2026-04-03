class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int s=max(weights);
        int e=sum(weights);
        while(s<=e){
            int mid=s+(e-s)/2;
            int d=dayss(weights,days,mid);
            if(d<=days)e=mid-1;
            else{
                s=mid+1;
            }

        }
        return s;


    }
    public int dayss(int[] weights,int days,int capacity){
            int day=1;
            int load=0;
            for(int i=0;i<weights.length;i++){
                if(weights[i]+load>capacity){
                    day+=1;
                    load=weights[i];
                }
                else{
                    load+=weights[i];
                }
            }
            return day;
    }
    public int max(int[] arr){
        int ans=Integer.MIN_VALUE;
        for(int i=0;i<arr.length;i++){
            ans=Math.max(ans,arr[i]);
        }
        return ans;
    }
    public int sum(int []arr){
        int sum=0;
        for(int i:arr){
            sum+=i;
        }
        return sum;
    }
}