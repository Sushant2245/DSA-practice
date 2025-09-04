class Solution {
    public int findClosest(int x, int y, int z) {
        int xreach=Math.abs(x-z);
        int yreach=Math.abs(y-z);
        if(xreach>yreach){
            return 2;
        }
        else if(xreach<yreach){
            return 1;
        }
        return 0;
        
    }
}