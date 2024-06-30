package Graphs;

import java.util.List;

public class ConnectedComponent {

    private void dfs(int v, List<List<Integer>> graph, boolean[] vis) {
        vis[v] = true;
        for(int neighbour : graph.get(v)) {
            if(!vis[neighbour]) {
                dfs(neighbour, graph, vis);
            }
        }
    }
    public int findComponents(List<List<Integer>> graph, int V) {
        boolean[] vis = new boolean[V];

        int component = 0;

        for(int v=0;v<V;v++) {
            if(!vis[v]) {
                component++;
                dfs(v, graph, vis);
            }
        }
        return component;
    }
}
