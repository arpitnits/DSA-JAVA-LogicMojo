package Backtracking;

public class Sudoku {

    private boolean isSafe(char[][] board, int value, int row, int col, int n) {


        //check 3*3 matrix
        int sqrt = (int)Math.sqrt(n);
        int min_row=row-row%sqrt, max_row=min_row+sqrt, min_col=col-col%sqrt, max_col=min_col+sqrt;

        for(int i=min_row;i<max_row;i++) {
            for(int j=min_col;j<max_col;j++){
                if(board[i][j]==value)
                    return false;
            }
        }

        //check column
        for(int dupCol=0;dupCol<n;dupCol++) {
            if(board[row][dupCol]==value)
                return false;
        }

        //check row
        for(int dupRow=0;dupRow<n;dupRow++) {
            if(board[dupRow][col]==value)
                return false;
        }

        return true;
    }

    private boolean backtrackSudoku(char[][] board, int n) {

        int row=-1, col=-1;
        boolean isEmpty = false;
        for(int i=0;i<n;i++) {
            for(int j=0;j<n;j++) {
                if(board[i][j]=='.') {
                    isEmpty = true;
                    row = i;
                    col = j;
                    break;
                }
            }
            if(isEmpty) {
                break;
            }
        }

        if(!isEmpty){
            return true;
        }

        for(int value=1;value<=9;value++) {
            if (isSafe(board, (char)(value+'0'), row, col, n)) {
                board[row][col] = (char)(value+'0');
                if (backtrackSudoku(board, n)) {
                    return true;
                } else {
                    board[row][col] = '.';
                }
            }
        }
        return false;
    }

    public void solveSudoku() {
        char[][] board = {{'5','3','.','.','7','.','.','.','.'},
                           {'6','.','.','1','9','5','.','.','.'},
                            {'.','9','8','.','.','.','.','6','.'},
                            {'8','.','.','.','6','.','.','.','3'},
                             {'4','.','.','8','.','3','.','.','1'},
                    {'7','.','.','.','2','.','.','.','6'},
                {'.','6','.','.','.','.','2','8','.'},
                {'.','.','.','4','1','9','.','.','5'},
                {'.','.','.','.','8','.','.','7','9'}};
        backtrackSudoku(board, 9);
    }
}
