package Graphs;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;

public class TopologicalSort {


    public int[] topologicalSort(int V, ArrayList<ArrayList<Integer>> adj) {

        Queue<Integer> q = new ArrayDeque<>();
        int[] inDegree = new int[V];
        int[] ans = new int[V];
        int index=0;

        for(int i=0;i<V;i++) {
            for(int neighbour : adj.get(i)) {
                inDegree[neighbour]++;
            }
        }

        //add All node with indegree=0
        for(int i=0;i<V;i++) {
            if(inDegree[i]==0)
                q.add(i);
        }

        while (!q.isEmpty()) {
            int curr = q.poll();
            ans[index++] = curr;
            for(int neighbour : adj.get(curr)) {
                inDegree[neighbour]--;
                if(inDegree[neighbour]==0) q.add(neighbour);
            }
        }
        return ans;
    }
}
