class Solution {
    public int orangesRotting(int[][] grid) {
        int n= grid.length;
        int m=grid[0].length;
        int fresh=0;
       Queue<int[]>q= new LinkedList<>();
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]==2){
                    q.add(new int[]{i,j,0});

                }
                if(grid[i][j]==1)fresh++;
            }
        }
        if(fresh==0) return 0;
        int time=0;
        int[] dirR={-1,1,0,0};
        int[] dirC={0,0,-1,1};
        while(!q.isEmpty()){
            int[] curr=q.poll();
            int r=curr[0];
            int c=curr[1];
            int t=curr[2];
            time=t;
            for(int k=0;k<4;k++){
                int nr=r+dirR[k];
                int nc=c+dirC[k];

                if(nr>=0 && nr<n && nc>=0 && nc<m && grid[nr][nc]==1){
                    grid[nr][nc]=2;
                    fresh--;
                    q.add(new int[]{nr,nc,t+1});
                }
            }
        }
        if(fresh>0)return -1;
        return time;

    }
}