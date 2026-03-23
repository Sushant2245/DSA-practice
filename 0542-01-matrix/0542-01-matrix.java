class Solution {
    public int[][] updateMatrix(int[][] mat) {
        Queue<int[]>q=new LinkedList<>();
        int m=mat.length;
        int n=mat[0].length;
        int result[][]=new int[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(mat[i][j]==0){
                    result[i][j]=0;
                    q.offer(new int[]{i,j});
                }
                else{
                    result[i][j]=-1;
                }
            }
        }

        while(!q.isEmpty()){
            int pair[]=q.poll();
            int r=pair[0];
            int c=pair[1];

            if(r-1>=0 && result[r-1][c]==-1){
                result[r-1][c]=result[r][c]+1;
                q.offer(new int[]{r-1,c});
            }
             if(r+1<m && result[r+1][c]==-1){
                result[r+1][c]=result[r][c]+1;
                q.offer(new int[]{r+1,c});
            }
          if(c+1<n && result[r][c+1]==-1){
                result[r][c+1]=result[r][c]+1;
                q.offer(new int[]{r,c+1});
            }
          if(c-1>=0 && result[r][c-1]==-1){
                result[r][c-1]=result[r][c]+1;
                q.offer(new int[]{r,c-1});
            }

        }
        return result;
    }
}