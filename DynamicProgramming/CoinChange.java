package DynamicProgramming;

public class CoinChange {

    public int recursive(int[] coins, int n, int sum) {
        if(n<0 || sum<0)    return -1; //not possible

        if(sum==0) return 0;

        //take
        int take = recursive(coins, n, sum-coins[n]);

        //notTake
        int notTake = recursive(coins, n-1, sum);

        if(take==-1)    return notTake;
        if(notTake==-1) return take+1;
        return Math.min(take+1, notTake);
    }

    public int memoization(int[] coins, int n, int sum, int[][] dp) {
        if(n<0 || sum<0)    return -1; //not possible

        if(sum==0) return 0;

        if(dp[n][sum]!=-2)  return dp[n][sum];

        //take
        int take = memoization(coins, n, sum-coins[n], dp);

        //notTake
        int notTake = memoization(coins, n-1, sum, dp);

        if(take==-1)    dp[n][sum] = notTake;
        else if(notTake==-1) dp[n][sum] = take+1;
        else dp[n][sum] = Math.min(take+1, notTake);

        return dp[n][sum];
    }
}
