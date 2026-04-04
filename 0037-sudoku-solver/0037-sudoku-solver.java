class Solution {
    public void solveSudoku(char[][] board) {
        solve(board);
    }
    public boolean solve(char[][] board ){
        for(int i=0;i<9;i++){
            for(int j=0;j<9;j++){
                if(board[i][j]=='.'){
                    for(char num='1';num<='9';num++){
                        if(isSafe(board,num,i,j)){
                            board[i][j]=num;
                            if(solve(board))return true;
                            else {
                                board[i][j]='.';
                            }
                        }

                    }
                    return false;
                }
                
            }
        }
        return true;
    }
    public boolean isSafe(char[][] board,char num,int row,int col){
        for(int i=0;i<board.length;i++){
            if(board[i][col]==num)return false;
            if(board[row][i]==num)return false;
            if(board[3*(row/3)+i/3][3*(col/3)+i%3]==num)return false;

        }
        return true;
    }
}