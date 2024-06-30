package DynamicProgramming;

import java.util.Arrays;

public class MinimumSum {

    public int recursive(int[][] grid, int row, int col, int[][] dp) {
        if(row<0 || col<0)  return Integer.MAX_VALUE;

        if(row==0 && col==0)    return grid[row][col];

        if(dp[row][col]!=-1)    return dp[row][col];

        dp[row][col]= grid[row][col] + Math.min(
                recursive(grid, row-1, col, dp),
                recursive(grid, row, col-1, dp)
        );

        return dp[row][col];
    }


    public int minPathSum(int[][] grid) {
        int rowSize = grid.length;
        int colSize = grid[0].length;

        int[][] dp = new int[rowSize][colSize];
        for(int[] d: dp)    Arrays.fill(d, -1);

        return recursive(grid, rowSize-1, colSize-1, dp);
    }
}
