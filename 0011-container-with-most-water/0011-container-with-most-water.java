// class Solution {
//     public int maxArea(int[] height) {
//         int ans=0;
//         int n=height.length;
//         int left=0;
//         int right=n-1;
//         while(left<right){
//             if(height[left]<height[right]){
//                 ans=Math.max(ans,((left-right)*height[left]));
//                 left++;
//             }
//             else{
//                 ans=Math.max(ans,((left-right)*height[right]));
//                 right++;
//             }
//         }
//         return ans;
//     }
// }
class Solution {
    public int maxArea(int[] height) {
        int ans = 0;
        int n = height.length;
        int left = 0;
        int right = n - 1;
        
        while (left < right) {
            // Calculate the area with the current left and right
            int currentArea = Math.min(height[left], height[right]) * (right - left);
            ans = Math.max(ans, currentArea);
            
            // Move the pointer that points to the shorter line
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;  // This should be decrementing, not incrementing
            }
        }
        
        return ans;
    }
}
