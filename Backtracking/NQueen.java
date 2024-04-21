package Backtracking;

import java.util.Arrays;

public class NQueen {

    public static boolean isSafe(char[][] grid, int row, int col, int n) {

        int tempRow, tempCol;

        //leftRow
        tempCol = col;
        while(tempCol>=0) {
            if(grid[row][tempCol] == 'Q')
                    return false;
            tempCol--;
        }

        //upperDiagonal
        tempRow=row; tempCol=col;
        while(tempCol>=0 && tempRow>=0) {
            if(grid[tempRow][tempCol] == 'Q')
                return false;
            tempCol--; tempRow--;
        }


        //lowerDiagonal
        tempRow=row; tempCol=col;
        while(tempCol>=0 && tempRow<n) {
            if(grid[tempRow][tempCol] == 'Q')
                return false;
            tempCol--; tempRow++;
        }

        return true;
    }
    public static void findAllPlacements(char[][] grid,int col, int n) {
        if(col==n) {
            System.out.println(Arrays.deepToString(grid));
            return;
        }

        for(int row=0;row<n;row++) {
            if(isSafe(grid, row, col, n)) {
                grid[row][col] = 'Q';
                findAllPlacements(grid, col+1, n) ;
                grid[row][col] = '.';
            }
        }
    }
    public static void main(String[] args) {
        int n = 4;

        char[][] grid = new char[n][n];
        for(char[] g : grid) {
            Arrays.fill(g, '.');
        }

        findAllPlacements(grid, 0, n) ;
    }
}
