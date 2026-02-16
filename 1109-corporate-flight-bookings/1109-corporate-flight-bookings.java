class Solution {
    public int[] corpFlightBookings(int[][] bookings, int n) {
        int ans[]=new int[n];
        for(int [] ele:bookings){
            int firstFlight=ele[0];
            int lastFlight=ele[1];
            int seats=ele[2];

            for(int i= firstFlight-1;i<=lastFlight-1;i++){
                ans[i]=ans[i]+seats;
            }
        }
        return ans;
    }
}