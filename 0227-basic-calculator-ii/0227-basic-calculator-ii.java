class Solution {
    public int calculate(String s) {
        char sign='+';
        Stack<Integer> st= new Stack<>();
        int num=0;
        int n= s.length();
        for(int i=0;i<n;i++){
            char c= s.charAt(i);
            if(Character.isDigit(c)){
                num=num*10+(c-'0');
            }
            if((!Character.isDigit(c) && c!=' ')||i==n-1 ){
                if(sign=='+'){
                    st.push(num);
                }
                else if(sign=='-'){
                    st.push(-num);
                }
                else if(sign=='*'){
                    st.push(st.pop()*num);
                }
                else{
                    st.push(st.pop()/num);
                }
                sign=c;
                num=0;
            }

        }
        int result=0;
        while(!st.isEmpty()){
            result+=st.pop();
        }
        return result;
    }
}