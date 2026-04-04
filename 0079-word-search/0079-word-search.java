class Solution {
    public boolean exist(char[][] board, String word) {
        int m= board.length;
        int n=board[0].length;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(board[i][j]==word.charAt(0)){
                    if(dfs(board,word,0,i,j))return true;
                }
            }
        }
        return false;
    }
    public boolean dfs(char[][] board, String word, int index,int i,int j){
        int m=board.length;
        int n=board[0].length;
        if(index==word.length())return true;
        if(i<0 || j<0||i>=m || j>=n || board[i][j]!=word.charAt(index)|| board[i][j]=='.')return false;
        char temp=board[i][j];
        board[i][j]='.';
        boolean result=dfs(board,word,index+1,i+1,j)||
                       dfs(board,word,index+1,i-1,j)||
                       dfs(board,word,index+1,i,j+1)||
                       dfs(board,word,index+1,i,j-1);                     
        board[i][j]=temp;
        return result;

    }
}