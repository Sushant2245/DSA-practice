class Solution {
    public boolean exist(char[][] board, String word) {
        int n=board.length;
        int m=board[0].length;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(board[i][j]==word.charAt(0)){
                   if(dfs(board,word,i,j,n,m,0))return true;
                }
            }
        }
        return false;
    }
    public boolean dfs(char[][] board, String word,int i,int j,int n,int m,int index){
        if(index==word.length())return true;
        if(i<0 || j<0 || i>=n || j>=m || board[i][j]!=word.charAt(index) || board[i][j]=='.' )return false;
        char temp=board[i][j];
        board[i][j]='.';
        boolean result=dfs(board,word,i+1,j,n,m,index+1)||
                       dfs(board,word,i,j+1,n,m,index+1)|| 
                       dfs(board,word,i-1,j,n,m,index+1)||
                       dfs(board,word,i,j-1,n,m,index+1);
        board[i][j]=temp;
        return result;
    }
}