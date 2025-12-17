class Solution {
    public int[][] updateMatrix(int[][] mat) {
        int n=mat.length;
        int m=mat[0].length;
        int dist[][]= new int[n][m];
        Queue<int[]> q= new LinkedList<>();
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(mat[i][j]==0){
                    dist[i][j]=0;
                    q.offer(new int[]{i,j});

                }
                else{
                    dist[i][j]=-1;
                }
            }
        }
        while(!q.isEmpty()){
            int pair[]=q.poll();
            int r=pair[0];
            int c=pair[1];

            if(r+1<n && dist[r+1][c]==-1){
                dist[r+1][c]=dist[r][c]+1;
                q.offer(new int[]{r+1,c});
            }
            if(c+1<m && dist[r][c+1]==-1){
                dist[r][c+1]=dist[r][c]+1;
                q.offer(new int[]{r,c+1});
            }
            if(r-1>=0 && dist[r-1][c]==-1){
                dist[r-1][c]=dist[r][c]+1;
                q.offer(new int[]{r-1,c});
            }
            if(c-1>=0 && dist[r][c-1]==-1){
                dist[r][c-1]=dist[r][c]+1;
                q.offer(new int[]{r,c-1});
            }
        }
        return dist;
    }
}