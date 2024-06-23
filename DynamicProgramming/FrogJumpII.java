package DynamicProgramming;

import java.util.Arrays;

public class FrogJumpII {

    //TC = O(N*K)
    private static int tabulation(int n, int[] heights, int k) {
        int[] dp = new int[n];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        dp[1] = Math.abs(heights[1]-heights[0]);

        for(int i=2;i<n;i++) {
            for(int j=i-1;j>=0; j--) {
                if(i-j > k) break;
                dp[i] = Math.min(dp[i], dp[j] + Math.abs(heights[i]-heights[j]));
            }
        }
        return dp[n-1];
    }
}
