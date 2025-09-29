class Solution {
    public String reverseOnlyLetters(String s) {
        char arr[]=s.toCharArray();
        int l=0;
        int r=arr.length-1;
        while(l<r){
            if(Character.isLetter(arr[l]) && Character.isLetter(arr[r])){
                char temp=arr[l];
                arr[l]=arr[r];
                arr[r]=temp;
                l++;
                r--;
            }
            else if(Character.isLetter(arr[l])){
                r--;
            }
            else{
                l++;
            }
        }
        return new String(arr);
    }
}