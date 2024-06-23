package DynamicProgramming;

import java.util.Arrays;

public class FrogJump {


    private static int memoization(int n, int[] heights, int[] dp) {
        if(n==0)    return 0;
        if(n==1)    return Math.abs(heights[1]-heights[0]);

        if(dp[n]==-1) {

            int eneryLostOneStep = memoization(n-1, heights, dp);
            int eneryLosTwoStep = memoization(n-2, heights, dp);
            dp[n] = Math.min(eneryLostOneStep + Math.abs(heights[n]-heights[n-1]),
                    eneryLosTwoStep + Math.abs(heights[n]-heights[n-2]));

        }
        return dp[n];
    }

    private static int tabulation(int n, int[] heights) {
        int[] dp = new int[n];
        dp[0] = 0;
        dp[1] = Math.abs(heights[1]-heights[0]);

        for(int i=2;i<n;i++) {
            dp[i] = Math.min(dp[i-1] + Math.abs(heights[n]-heights[n-1]),
                    dp[i-2] + Math.abs(heights[n]-heights[n-2]));
        }
        return dp[n-1];
    }


    public static int frogJump(int n, int[] heights) {
        int[] dp = new int[n];
        Arrays.fill(dp, -1);

        return memoization(n-1, heights, dp);
    }
}
