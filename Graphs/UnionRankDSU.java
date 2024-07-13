package Graphs;

import java.util.Arrays;

public class UnionRankDSU {

    static class Node {
        int parent;
        int rank;
    }

    public Node[] nodes;

    UnionRankDSU(int V) {
        nodes = new Node[V];
        for(int i=0;i<V;i++) {
            nodes[i].parent = -1;
            nodes[i].rank=0;
        }
    }

    public int find(int v) {
        if(nodes[v].parent==-1)   return v;
        return nodes[v].parent = find(nodes[v].parent);
    }

    public void union(int x, int y) {
        int p1 = find(x); //3
        int p2 = find(y); //3

        if(p1!=p2) {
            if(nodes[p1].rank > nodes[p2].rank) {
                nodes[p2].parent = p1;
            } else if(nodes[p2].rank > nodes[p1].rank) {
                nodes[p1].parent = p2;
            } else {
                nodes[p1].parent = p2;
                nodes[p2].rank++;
            }
        }
    }
}
