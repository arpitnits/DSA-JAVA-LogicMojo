package Graphs;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;

public class Traversal {

    public ArrayList<Integer> bfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {

        boolean[] vis = new boolean[V];
        Queue<Integer> q = new ArrayDeque<>();
        ArrayList<Integer> bfs = new ArrayList<>();

        int startNode = 0;
        q.add(startNode);
        vis[0] = true;

        while(!q.isEmpty()) {
            Integer curr = q.poll();
            bfs.add(curr);

            for(int neighbour : adj.get(curr)) {
                if(!vis[neighbour]) {
                    q.add(neighbour);
                    vis[neighbour] = true;
                }
            }
        }

        return bfs;
    }

    public void dfs(int curr, ArrayList<ArrayList<Integer>> adj, ArrayList<Integer> dfs, boolean[] vis) {
        dfs.add(curr);
        vis[curr] = true;

        for(int neigh : adj.get(curr)) {
            if(!vis[neigh]) {
                dfs(neigh, adj, dfs, vis);
            }
        }
    }

    public ArrayList<Integer> dfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {
        ArrayList<Integer> dfs = new ArrayList<>();
        boolean[] vis = new boolean[V];

        int startNode  =0;

        dfs(startNode, adj, dfs, vis);

        return dfs;
    }
}
