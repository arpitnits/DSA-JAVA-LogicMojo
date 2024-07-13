package Graphs;

import java.util.Arrays;

public class DSUNaive {

    public int[] parent;

    /*
    [0,1], [0,3], [2,3], [3,1]

    [1, 3,  3, -1]
     0  1   2   3
     */
    DSUNaive(int V) {
        parent = new int[V];
        Arrays.fill(parent, -1);
    }

    public int find(int v) {
        if(parent[v]==-1)   return v;
        return find(parent[v]);
    }

    public void union(int x, int y) {
        int p1 = find(x); //3
        int p2 = find(y); //3

        if(p1!=p2) {
            //different sets
            parent[p1] = p2;
        }
    }

}
