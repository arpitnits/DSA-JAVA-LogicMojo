package DynamicProgramming;

public class Knapsack {


    public static int helper(int W, int[] wt, int[] val, int n) {
        if(W<0 || n<0) return 0;

        //take
        int take = 0;
        if(wt[n]<=W)
            take = val[n] + helper(W-wt[n], wt, val, n-1);

        //notTake
        int notTake = helper(W, wt, val, n-1);

        return Math.max(take, notTake);
    }


    public static int knapSack(int W, int[] wt, int[] val, int n) {
        return 0;
    }
}
