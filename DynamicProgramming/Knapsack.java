package DynamicProgramming;

public class Knapsack {


    public static int recursive(int W, int[] wt, int[] val, int n) {
        if(W<0 || n<0) return 0;

        //take
        int take = 0;
        if(wt[n]<=W)
            take = val[n] + recursive(W-wt[n], wt, val, n-1);

        //notTake
        int notTake = recursive(W, wt, val, n-1);

        return Math.max(take, notTake);
    }


    public static int memoization(int W, int[] wt, int[] val, int n, int[][] dp) {
        if(W<0 || n<0) return 0;

        if(dp[n][W]!=-1)    return dp[n][W];

        //take
        int take = 0;
        if(wt[n]<=W)
            take = val[n] + memoization(W-wt[n], wt, val, n-1, dp);

        //notTake
        int notTake = memoization(W, wt, val, n-1, dp);

        dp[n][W] = Math.max(take, notTake);
        return dp[n][W];
    }


    public static int tabulation(int W, int[] wt, int[] val, int n) {
        int[][] dp = new int[n+1][W+1];

        for(int i=0;i<=n;i++) {
            for(int w =0; w<=W; w++) {
                if(i==0 || w==0) //base case
                    dp[i][w] =0;
                else if(wt[i-1]<=w) //Math.max(take, don't Take)
                    dp[i][w] = Math.max(dp[i-1][w-wt[i-1]] + val[i-1], dp[i-1][w]);
                else
                    dp[i][w] = dp[i-1][w]; // always don't take
            }
        }
        return dp[n][W];
    }
}
