package DynamicProgramming;

public class HouseRobber {


    public static int robRecursive(int[] nums, int n) {
        if(n<0) return 0;

        //include
        int include = nums[n] +  robRecursive(nums, n-2) ;

        //exclude
        int exclude = robRecursive(nums, n-1);

        return Math.max(include, exclude);
    }

    public static int memoization(int[] nums, int n, int[] dp) {
        if(n<0) return 0;

        if(dp[n]!=-1)   return dp[n];
        dp[n] = Math.max(nums[n] +  memoization(nums, n-2, dp), memoization(nums, n-1, dp));
        return dp[n];
    }


    public static int tabulation(int[] nums, int n) {
        int[] dp = new int[n];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[1], nums[0]);

        for(int i=2;i<n;i++) {
            dp[i] = Math.max(nums[i]+dp[i-2], dp[i-1]);
        }
        return dp[n-1];
    }
}
