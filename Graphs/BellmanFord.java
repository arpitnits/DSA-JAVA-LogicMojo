package Graphs;

import java.util.*;

public class BellmanFord {


    public int[] shortestPath(int[][] edges, int V, int E ,int src) {
        int[] distance = new int[V];
        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[src] = 0;

        List<List<ShortestDistance.Pair>> adj = new ArrayList<>();
        for(int i=0;i<V;i++)    adj.add(new ArrayList<>());

        //For Undirected
        for (int[] edge : edges) {
            adj.get(edge[0]).add(new ShortestDistance.Pair(edge[1], edge[2]));
            adj.get(edge[1]).add(new ShortestDistance.Pair(edge[0], edge[2]));
        }

        for(int i=0;i<V-1;i++) {
            for(int u =0; u<V;u++) {
                for(ShortestDistance.Pair neigh :  adj.get(u)) {
                    int v = neigh.node;
                    int w = neigh.weight;

                    if(distance[u]!=Integer.MAX_VALUE && distance[u]+w <distance[v]) {
                        distance[v] = distance[u] + w;
                    }
                }
            }
        }

        for(int u =0; u<V;u++) {
            for(ShortestDistance.Pair neigh :  adj.get(u)) {
                int v = neigh.node;
                int w = neigh.weight;

                if(distance[u]!=Integer.MAX_VALUE && distance[u]+w <distance[v]) {
                    Arrays.fill(distance, -1); //negative cycle
                }
            }
        }

        return distance;
    }

}
