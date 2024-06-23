package DynamicProgramming;

import java.util.Arrays;

public class ClimbingStairs {

    private int memoization(int n, int[] dp) {
        if(n<=2)    return n;

        if(dp[n]==-1)
            dp[n] = memoization(n-1, dp) + memoization(n-2, dp);
        return dp[n];
    }

    private int tabulation(int n) {
        int[] dp = new int[n+1];
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 2;

        for(int step = 3; step<=n;step++) {
            dp[step] = dp[step-1] + dp[step-2];
        }
        return dp[n];
    }

    public int climbStairs(int n) {
        int[] dp = new int[n+1];
        Arrays.fill(dp, -1);
        return memoization(n, dp);
    }
}
