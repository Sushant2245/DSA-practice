class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> result=new ArrayList<>();
        int [][] board=new int[n][n];
        solve(board,n,0,result);
        return result;
    }
    List<String> construct(int[][] board,int n){
        List<String> ls= new ArrayList<>();
        for(int i=0;i<n;i++){
            StringBuilder sb= new StringBuilder();
            for(int j=0;j<n;j++){
                if(board[i][j]==1)sb.append('Q');
                else{
                    sb.append('.');
                }
            }
            ls.add(sb.toString());
        }
        return ls;
    }
    boolean isSafe(int row, int col,int n,int[][] board){
        int r= row;
        int c=col;
        while(r>=0 && c>=0){
            if(board[r][c]==1)return false;
            r--;
            c--;
        }
        r=row;
        c=col;
        while(c>=0){
            if(board[r][c]==1)return false;
            c--;
        }
        r=row;
        c=col;
        while(r<n && c>=0){
            if(board[r][c]==1)return false;
            r++;
            c--;
        }
        return true;
    }
    void solve(int[][] board ,int n, int col,List<List<String>> result){
        if(col==n){
            result.add(construct(board,n));
            return;
        }
        for(int row=0; row<n;row++){
            if(isSafe(row,col,n,board)){
                board[row][col]=1;
                solve(board,n,col+1,result);
               board[row][col]=0;
            }

        }
    }
}