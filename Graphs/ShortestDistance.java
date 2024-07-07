package Graphs;

import java.util.*;

public class ShortestDistance {

    static class Pair {
        int node;
        int weight;

        Pair(int n, int w) {
            this.node = n;
            this.weight = w;
        }
    }

    //O(V*E)
    public int[] shortestPath(int[][] edges, int V, int E ,int src) {
        int[] distance = new int[V];
        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[src] = 0;

        List<List<Pair>> adj = new ArrayList<>();
        for(int i=0;i<V;i++)    adj.add(new ArrayList<>());

        //For Undirected
        for (int[] edge : edges) {
            adj.get(edge[0]).add(new Pair(edge[1], edge[2]));
            adj.get(edge[1]).add(new Pair(edge[0], edge[2]));
        }

        Queue<Integer> q = new ArrayDeque<>();
        q.add(src);

        while (!q.isEmpty()) {
            int u = q.poll();

            for(Pair neigh : adj.get(u)) {
                int v = neigh.node;
                int w = neigh.weight;
                if(distance[v] > distance[u]+ w) {
                    distance[v] = distance[u]+ w;
                    q.add(v);
                }
            }
        }

        return distance;
    }

    //O(V+E)
    public int[] shortestPathTopological(int[][] edges, int V, int E ,int src) {
        int[] distance = new int[V];
        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[src] = 0;

        List<List<Pair>> adj = new ArrayList<>();
        for(int i=0;i<V;i++)    adj.add(new ArrayList<>());

        for (int[] edge : edges) {
            adj.get(edge[0]).add(new Pair(edge[1], edge[2]));
        }

        int[] topoOrder = topologicalOrder();

        for(int u : topoOrder) {
            for(Pair neigh : adj.get(u)) {
                int v = neigh.node;
                int w = neigh.weight;
                if(distance[v] > distance[u]+ w) {
                    distance[v] = distance[u]+ w;
                }
            }
        }
        return distance;
    }

    private int[] topologicalOrder() {
        //Implement topological Order from other file
        return new int[2];
    }
}
