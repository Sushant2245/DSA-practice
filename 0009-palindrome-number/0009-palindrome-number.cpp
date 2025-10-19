class Solution {
public:
    bool isPalindrome(int x) {
       long long int reversed=0;
      long long   int original = x;
        while(x!=0){
           
            reversed= (reversed*10)+x%10;
            x=x/10;

        }
        if(original<0){
            return false;
        }
        if(reversed==original){
            return true;
        }
      
       
        else{
            return false;
        }
    }
};