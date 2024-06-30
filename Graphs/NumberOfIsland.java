package Graphs;

public class NumberOfIsland {

    int[][] dir = {{-1,0}, {1,0}, {0,1}, {0,-1}};

    private boolean isSafe(char[][] grid, int row, int col, int m, int n) {
        return (row>=0 && row<m && col>=0 && col<n && grid[row][col]=='1');
    }

    private void dfs(char[][] grid, int row, int col, int m, int n) {
        grid[row][col] = '2'; //to mark visited

        for(int[] d: dir) {
            int newRow = row + d[0];
            int newCol = col + d[1];

            if(isSafe(grid, newRow, newCol, m, n)) {
                dfs(grid, newRow, newCol, m, n);
            }
        }
    }
    public int numIslands(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        int islands=0;

        for(int i=0;i<m;i++) {
            for (int j=0;j<n;j++) {
                if(isSafe(grid, i, j, m, n)) {
                    islands++;
                    dfs(grid, i, j, m , n);
                }
            }
        }
        return islands;
    }
}
