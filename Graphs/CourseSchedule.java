package Graphs;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;

public class CourseSchedule {


    public boolean canFinish(int numCourses, int[][] prerequisites) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i=0;i<numCourses;i++)  adj.add(new ArrayList<>());

        for (int[] prerequisite : prerequisites) {
            adj.get(prerequisite[1]).add(prerequisite[0]);
        }

        int completedCourses = topologicalSort(numCourses, adj);

        return completedCourses==numCourses;
    }


    public int topologicalSort(int V, ArrayList<ArrayList<Integer>> adj) {

        Queue<Integer> q = new ArrayDeque<>();
        int[] inDegree = new int[V];

        int completed=0;

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
            completed++;
            for(int neighbour : adj.get(curr)) {
                inDegree[neighbour]--;
                if(inDegree[neighbour]==0) q.add(neighbour);
            }
        }
        return completed;
    }
}
