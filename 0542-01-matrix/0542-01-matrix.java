class Solution {
    public int[][] updateMatrix(int[][] mat) {
        int m= mat.length;
        int n=mat[0].length;
        Queue<int[]> q= new LinkedList<>();
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
            int[] pair= q.poll();
            int i=pair[0];
            int j=pair[1];

            if(i+1<m && result[i+1][j]==-1){
                result[i+1][j]=result[i][j]+1;
                q.offer(new int[]{i+1,j});
            }
            if(j+1<n && result[i][j+1]==-1){
                result[i][j+1]=result[i][j]+1;
                q.offer(new int[]{i,j+1});
            }
            if(i-1>=0 && result[i-1][j]==-1){
                result[i-1][j]=result[i][j]+1;
                q.offer(new int[]{i-1,j});
            }
            if(j-1>=0 && result[i][j-1]==-1){
                result[i][j-1]=result[i][j]+1;
                q.offer(new int[]{i,j-1});
            }
        }
        return result;
    }
}