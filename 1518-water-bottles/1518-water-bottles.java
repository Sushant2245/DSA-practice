class Solution {
    public int numWaterBottles(int numBottles, int numExchange) {
       int total=numBottles;
       int empty=numBottles;
        while(empty>=numExchange){
          int bottles= empty/numExchange;
          total+=bottles;
          empty=bottles+(empty%numExchange);

        }
        return total;
    }
}