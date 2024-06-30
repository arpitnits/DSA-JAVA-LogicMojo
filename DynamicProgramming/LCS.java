package DynamicProgramming;

public class LCS {

    public int recursive(String text1, String text2, int m, int n) {
        if(m<0 || n<0) return 0;

        //if equal
        if(text1.charAt(m) == text2.charAt(n)) {
            return recursive(text1, text2, m-1, n-1) + 1;
        } else {
            return Math.max(
                    recursive(text1, text2, m-1, n) ,
                    recursive(text1, text2, m, n-1)
            );
        }
    }

    public int memoization(String text1, String text2, int m, int n, int[][] dp) {
        if(m<0 || n<0) return 0;

        if(dp[m][n]!=-1)    return dp[m][n];

        if(text1.charAt(m) == text2.charAt(n)) {
            dp[m][n] = memoization(text1, text2, m-1, n-1, dp) + 1;
        } else {
            dp[m][n] = Math.max(
                    memoization(text1, text2, m-1, n, dp) ,
                    memoization(text1, text2, m, n-1, dp)
            );
        }
        return dp[m][n];
    }

    public int tabulation(String text1, String text2) {
        int m = text1.length();
        int n = text2.length();

        int[][] dp = new int[m+1][n+1];

        for(int i=0;i<=m;i++) {
            for(int j=0;j<=n;j++) {
                if(i==0 || j==0)
                    dp[i][j]=0;
                else if(text1.charAt(i-1)==text2.charAt(j-1)) {
                    dp[i][j] = dp[i-1][j-1] +1;
                } else {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }
        return dp[m][n];
    }
}
