package Graphs;

import java.util.ArrayDeque;
import java.util.Queue;

public class RottenOranges {

    static int[][] dir = {{-1,0}, {1,0}, {0,1}, {0,-1}};

    static class Node {
        int x;
        int y;

        Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    private static boolean isSafe(int[][] grid, int row, int col, int m, int n) {
        return row>=0 && row<m && col>=0 && col<n && grid[row][col]==1;
    }

    public static int orangesRotting(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        Queue<Node> q = new ArrayDeque<>();

        //pick all rotten oranges
        for(int i=0;i<m;i++) {
            for(int j=0;j<n;j++) {
                if(grid[i][j]==2) {
                    q.add(new Node(i,j));
                    grid[i][j] = 3;
                }
            }
        }

        int time=-1;

        while(!q.isEmpty()) {
            int size = q.size();
            time++;
            for(int i=0;i<size;i++) {
                Node curr = q.poll();

                for(int[] d : dir) {
                    int newRow = curr.x + d[0];
                    int newCol = curr.y + d[1];

                    if(isSafe(grid, newRow, newCol, m, n)) {
                        q.add(new Node(newRow, newCol));
                        grid[newRow][newCol] = 3;
                    }
                }
            }
        }

        for(int i=0;i<m;i++) {
            for(int j=0;j<n;j++) {
                if(grid[i][j]==1) {
                    return -1;
                }
            }
        }
        return time;
    }

    public static void main(String[] args) {
        int[][] grid = {{2,1,1},{1,1,0},{0,1,1}};

        System.out.println(orangesRotting(grid));
    }
}
