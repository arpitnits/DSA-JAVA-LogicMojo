package Graphs;

import java.util.*;

public class DijkstraAlgo {

    public int[] dijkstra(int[][] edges, int V, int E ,int src) {
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

        PriorityQueue< ShortestDistance.Pair> q = new PriorityQueue<>(Comparator.comparingInt(p-> p.weight));
        q.add(new ShortestDistance.Pair(src, 0));

        while (!q.isEmpty()) {
            ShortestDistance.Pair pair = q.poll();
            int u = pair.node;

            for(ShortestDistance.Pair neigh : adj.get(u)) {
                int v = neigh.node;
                int w = neigh.weight;
                if(distance[v] > distance[u]+ w) {
                    distance[v] = distance[u]+ w;
                    q.add(new ShortestDistance.Pair(v, distance[v]));
                }
            }
        }
        return distance;
    }
}
