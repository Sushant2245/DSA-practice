import java.util.Arrays;

class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[1] - b[1]); 
        int i = 1;
        int count = 0;
        int prevEnd = intervals[0][1];

        while (i < intervals.length) {
            if (intervals[i][0] < prevEnd) {
                count++;
            } else {
                prevEnd = intervals[i][1];
            }
            i++;
        }
        return count;
    }
}
