class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        int n=grid.length;
        if(grid[0][0]==1 || grid[n-1][n-1]==1)return -1;
        Queue<int[]> q= new LinkedList<>();
        int dist=1;
        grid[0][0]=1;
        q.offer(new int[]{0,0});
        while(!q.isEmpty()){
            int size=q.size();
            for(int i=0;i<size;i++){
                int[] cur=q.poll();
                int r=cur[0];
                int c=cur[1];
                if(r==n-1 && c==n-1) return dist;
                if(r-1>=0 && grid[r-1][c]==0){
                    q.offer(new int[]{r-1,c});
                    grid[r-1][c]=1;
                }
                 if(r+1<n && grid[r+1][c]==0){
                    q.offer(new int[]{r+1,c});
                    grid[r+1][c]=1;
                }
                 if(c-1>=0 && grid[r][c-1]==0){
                    q.offer(new int[]{r,c-1});
                    grid[r][c-1]=1;
                }
                 if(c+1<n && grid[r][c+1]==0){
                    q.offer(new int[]{r,c+1});
                    grid[r][c+1]=1;
                }
                 if(r-1>=0 && c-1>=0 && grid[r-1][c-1]==0){
                    q.offer(new int[]{r-1,c-1});
                    grid[r-1][c-1]=1;
                }
                if(r+1<n && c+1<n && grid[r+1][c+1]==0){
                    q.offer(new int[]{r+1,c+1});
                    grid[r+1][c+1]=1;
                }
                if(r-1>=0 && c+1<n && grid[r-1][c+1]==0){
                    q.offer(new int[]{r-1,c+1});
                    grid[r-1][c+1]=1;
                }
                if(r+1<n && c-1>=0 && grid[r+1][c-1]==0){
                    q.offer(new int[]{r+1,c-1});
                    grid[r+1][c-1]=1;
                }
            }
            dist++;
        }
        return -1;
    }
}