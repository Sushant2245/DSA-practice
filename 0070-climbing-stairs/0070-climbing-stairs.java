class Solution {
    public int climbStairs(int n) {
        if (n <= 2) return n;
        int oneStep = 2;  // ways to reach (i-1)
        int twoStep = 1;  // ways to reach (i-2)
        int result = 0;

        for (int i = 3; i <= n; i++) {
            result = oneStep + twoStep;
            twoStep = oneStep;
            oneStep = result;
        }
        return oneStep;
    }
}
