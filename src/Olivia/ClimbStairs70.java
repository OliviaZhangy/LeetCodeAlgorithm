package Olivia;

public class ClimbStairs70 {
    public int climbStairs(int n) {

        /* special case for n=0,1,2 */
        if (n == 0)
            return 0;
        if (n == 1)
            return 1;
        if (n == 2)
            return 2;

        int[] dp = new int[n];
        dp[0] = 1;
        dp[1] = 2;

        /* each element represent the number of ways */
        for (int i = 2; i < n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n - 1];

    }
}
