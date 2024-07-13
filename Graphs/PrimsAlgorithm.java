package Graphs;

import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class PrimsAlgorithm {

    static class Pair {
        int v;
        int w;

        Pair(int n, int w) {
            this.v = n;
            this.w = w;
        }
    }

    //edges = (u,v,w)
    //O((V+E)*logV) = ~O(E logV)
    public static int spanningTree(int V, int E, List<List<int[]>> adj) {
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[1])); //minHeap
        boolean[] vis = new boolean[V];
        int cost=0, counter=0;

        pq.add(new int[]{0, 0});
        while(!pq.isEmpty()) {
            int[] p = pq.poll();
            if(vis[p[0]])    continue;

            vis[p[0]] = true;
            counter++;
            cost+= p[1];

            for(int[] neighbour : adj.get(p[0])) {
                if(!vis[neighbour[0]]) {
                    pq.add(neighbour); //logV
                }
            }
            if(counter==V)
                break;
        }
        return cost;
    }
}
