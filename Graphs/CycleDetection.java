package Graphs;

import java.util.ArrayList;

public class CycleDetection {

    //Time Complexity = traversal Using adj List O(V+E)

    public boolean parentApproachDFS(int curr, int parent, ArrayList<ArrayList<Integer>> adj, boolean[] vis) {
        vis[curr] = true;

        for(int neigh : adj.get(curr)) {
            if(!vis[neigh]) {
                if(parentApproachDFS(neigh, curr, adj, vis))
                    return true;
            } else if(neigh!=parent){
                //vis and neigh is not parent then it is getting revisited, hence cycle
                return true;
            }
        }
        return false;
    }

    public boolean isCyclicUndirected(int V, ArrayList<ArrayList<Integer>> adj) {
        boolean[] vis = new boolean[V];

        for(int i=0;i<V;i++) {
            if(!vis[i]) {
                if(parentApproachDFS(i, -1, adj, vis)) {
                    return true;
                }
            }
        }
        return false;
    }


    public boolean pathApproachDFS(int curr, ArrayList<ArrayList<Integer>> adj, boolean[] vis, boolean[] path) {
        vis[curr] = true;
        path[curr] = true;

        for(int neigh : adj.get(curr)) {
            if(!vis[neigh]) {
                if(pathApproachDFS(neigh, adj, vis, path))
                    return true;
            } else if(path[neigh]){
                //vis and neigh is not parent then it is getting revisited, hence cycle
                return true;
            }
        }
        path[curr] = false;
        return false;
    }


    public boolean isCyclicDirected(int V, ArrayList<ArrayList<Integer>> adj) {
        boolean[] vis = new boolean[V];
        boolean[] path = new boolean[V];

        for(int i=0;i<V;i++) {
            if(!vis[i]) {
                if(pathApproachDFS(i,  adj, vis, path)) {
                    return true;
                }
            }
        }
        return false;
    }
}
