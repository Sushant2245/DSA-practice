class Solution {
    public int calPoints(String[] operations) {
        Stack<Integer> st= new Stack<>();
        for(int i=0;i<operations.length;i++){
            String s=operations[i];
         if(s.equals("C")){
                st.pop();
            }
            else if(s.equals("D")){
                st.push(st.peek()*2);
            }
            else if(s.equals("+")){
                int a=st.pop();
                int b=st.pop();
                st.push(b);
                st.push(a);
                st.push(a+b);
            }
            else{
                st.push(Integer.parseInt(s));
            }
        }
        int result=0;
        while(!st.isEmpty()){
            result+=st.pop();
        }
        return result;
    }
}