class Solution {
    public int[] searchRange(int[] nums, int target) {
        int left=leftt(nums,target);
        int right=rightt(nums,target);
        if(left==nums.length || nums[left]!=target) return new int[]{-1,-1};
        return new int[]{left,right};
    }
    public int leftt(int[] nums,int target){
        int s=0;
        int e=nums.length-1;
        while(s<=e){
            int mid=s+(e-s)/2;
            if(nums[mid]>=target)e=mid-1;
            else{
                s=mid+1;
            }
        }
        return s;
    }
    public int rightt(int[] nums,int target){
        int s=0;
        int e=nums.length-1;
        while(s<=e){
            int mid=s+(e-s)/2;
            if(nums[mid]<=target){
                s=mid+1;
            }
            else{
                e=mid-1;
            }
        }
        return e;
    }
}