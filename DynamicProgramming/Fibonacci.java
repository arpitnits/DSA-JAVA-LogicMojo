package DynamicProgramming;

import java.util.Arrays;

public class Fibonacci {

    private static int memoization(int n, int[] dp) {
        if(dp[n]==-1)
            dp[n] = memoization(n-1, dp) + memoization(n-2, dp);
        return dp[n];
    }


    public static int fib(int n) {
        int[] dp = new int[n+1];
        Arrays.fill(dp, -1);
        dp[0]=0; dp[1]=1;

        return memoization(n, dp);
    }

    public int tabulation(int n) {
        int[] dp = new int[n+1];
        dp[0]=0; dp[1]=1;

        for(int i=2;i<=n;i++)
            dp[n] = dp[n-1] + dp[n-2];

        return dp[n];
    }

    public static void main(String[] args) {
        int n = 5;
        System.out.println(fib(5));
    }
}
