class Solution {
    public int largestRectangleArea(int[] heights) {
        int maxArea=0;
        Stack<Integer> st= new Stack<>();
        for(int i=0;i<heights.length;i++){
            while(!st.isEmpty() && heights[st.peek()]> heights[i]){
               int element=st.pop();
               int nse=i;
               int pse=st.isEmpty()?-1:st.peek();
               int area=heights[element]*(nse-pse-1);
               maxArea=Math.max(maxArea,area);

            }
            st.push(i);
        }
        while(!st.isEmpty()){
            int nse=heights.length;
            int element=st.pop();
            int pse=st.isEmpty()?-1:st.peek();
            int area=heights[element]*(nse-pse-1);
             maxArea=Math.max(maxArea,area);

        }
        return maxArea;
    }
}