package Backtracking;

import java.util.Arrays;

public class RatInMaze {

    static int[] rowInc = {-1,1,0,0 };
    static int[] colInc = {0,0,-1,1 };
    static char[] direction =  {'U', 'D', 'L', 'R'};



    public static boolean isSafe(int row, int col, int n, int[][] matrix, boolean[][] vis) {
        if(row>=0 && row<n && col>=0 && col<n && matrix[row][col]==1 && !vis[row][col])
            return true;
        return false;
    }

    public static void traverseMaze(int row, int col, int n, int[][] matrix, boolean[][] vis, String path) {

        if(row==n-1 && col==n-1) {
            System.out.println(path);
            return;
        }

        for(int i=0;i<rowInc.length;i++) {
            int nextRow = row + rowInc[i];
            int nextCol = col + colInc[i];
            char dir = direction[i];

            if(isSafe(nextRow, nextCol, n, matrix, vis)) {
                vis[nextRow][nextCol] = true;
                traverseMaze(nextRow,nextCol, n, matrix, vis, path+dir);
                vis[nextRow][nextCol] = false;
            }
        }
    }

    public static void main(String[] args) {
        int N =4;
        int [][] matrix = {{1, 0, 0, 0},
                {1, 1, 0, 1},
                {1, 1, 0, 0},
                {0, 1, 1, 1}};

        boolean[][] visited = new boolean[N][N];
        if(matrix[0][0] == 0)  {
            System.out.println("Not possible to get ANY PATHS");
        }

        visited[0][0] = true;
        traverseMaze(0,0, N, matrix, visited, "");
    }
}
