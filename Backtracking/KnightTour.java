package Backtracking;

import java.util.Arrays;

public class KnightTour {

    static int[] rowInc = {-2,-2, 2, 2, -1,1, -1, 1 };
    static int[] colInc = {-1,1, -1, 1, -2,-2, 2, 2 };



    public static boolean isSafe(int row, int col, int n, int[][] matrix) {
        if(row>=0 && row<n && col>=0 && col<n && matrix[row][col]==-1)
            return true;
        return false;
    }

    public static boolean traverseKnight(int row, int col, int n, int move, int[][] matrix) {

        if(move==n*n) {
            return true;
        }

        for(int i=0;i<rowInc.length;i++) {
            int nextRow = row + rowInc[i];
            int nextCol = col + colInc[i];

            if(isSafe(nextRow, nextCol, n, matrix)) {
                matrix[nextRow][nextCol] = move;
                if(traverseKnight(nextRow, nextCol, n, move+1, matrix)) {
                    return true;
                } else {
                    matrix[nextRow][nextCol] = -1;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int n = 5;

        int[][] matrix = new int[n][n];
        for(int[] m : matrix) {
            Arrays.fill(m, -1);
        }

        matrix[0][0] = 0;

        boolean possible = traverseKnight(0, 0, n, 1, matrix);

        if(possible) {
            for(int[] m : matrix) {
                for(int x : m) {
                    System.out.print(x + " ");
                }
                System.out.println();
            }
        } else {
            System.out.println("Not possible to get valid configuration");
        }

    }
}
