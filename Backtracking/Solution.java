package Backtracking;

import java.util.ArrayDeque;
import java.util.Queue;

public class Solution {

    static class Pair {
        int row;
        int col;

        Pair(int r, int c) {
            this.row = r;
            this.col = c;
        }
    }

    public static boolean isValid(int row, int col, int m, int n, int startColor, int[][] grid) {

        if(row>=0 && row<m && col>=0 && col<n && grid[row][col]==startColor) {
            //System.out.println("isValid " + row + " " + col + " " + grid[row][col]);
            return true;
        }

        return false;
    }

    static int[] Rx = {0,0,-1,1};
    static int[] Cx = {1,-1,0,0};

    private static boolean boarder(int row, int col, int m, int n, int[][] grid) {

        if(row==0 || row==m-1 || col==0 || col==n-1)
            return true;
        for(int i=0;i<4;i++) {
            int nextR = row + Rx[i];
            int nextC = col + Cx[i];

            if(nextR>=0 && nextR<m && nextC>=0 && nextC<n) {
                if(grid[nextR][nextC]!=-1)
                    return true;
            }
        }
        return false;
    }

    public static int[][] colorBorder(int[][] grid, int row, int col, int color) {
        Queue<Pair> q = new ArrayDeque<>();
        int m = grid.length;
        int n = grid[0].length;

        q.add(new Pair(row, col));
        int startColor = grid[row][col];
        grid[row][col] = -1;

        while(!q.isEmpty()) {
            Pair p = q.poll();


            int r = p.row;
            int c = p.col;
            //grid[r][c] = -1;
            //System.out.println(r + " " + c);


            for(int i=0;i<4;i++) {
                int newR = r + Rx[i];
                int newC = c + Cx[i];
                if(isValid(newR,newC,m,n,startColor, grid)) {
                    grid[newR][newC] = -1;
                    q.add(new Pair(newR,newC));
                }
            }
        }

        int[][] ans = new int[m][n];

        for(int i=0;i<m;i++) {
            for(int j=0;j<n;j++) {
                System.out.print(grid[i][j] + " ");
                if(grid[i][j] == -1) {
                    if(boarder(i, j, m,n,grid))
                        ans[i][j] = color;
                    else
                        ans[i][j] = startColor;
                } else {
                    ans[i][j] = grid[i][j];
                }
            }
            System.out.println();
        }
        //ans[row][col] = color;
        return ans;
    }

    public static void main(String[] args) {
        int[][] grid = {{1,2,1,2,1,2},{2,2,2,2,1,2},{1,2,2,2,1,2}};
        colorBorder(grid, 1,1,2);


    }
}
