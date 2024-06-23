package DynamicProgramming;

import java.util.Arrays;

public class LIS {

    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        Arrays.fill(dp, 1);

        int ans = 1;
        for(int i=1;i<n;i++) {
            for(int j=0;j<i;j++) {
                if(nums[j]< nums[i])
                    dp[i] = Math.max(dp[i], dp[j]+1);
            }
            ans = Math.max(ans, dp[i]);
        }
        return ans;
    }

    int ans =0;
    public int memoization(int[] nums, int[] dp, int n) {
        if(n==0)    return 1;
        if(dp[n]!=-1)   return dp[n];

        int lis =1;
        for(int i=0;i<n;i++) {
            if(nums[i] < nums[n]) {
                int prevLIS = memoization(nums, dp, i);
                lis = Math.max(lis, prevLIS + 1);
            }
        }

        memoization(nums, dp, n-1);
        ans = Math.max(ans, lis);
        dp[n] = lis;
        return dp[n];
    }
}
