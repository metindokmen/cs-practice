// The Ford-Fulkerson algorithm is used to find the maximum flow in a flow network, which is a directed graph where each edge has a capacity and represents the maximum amount of flow that can pass through it.
// The algorithm iteratively finds augmenting paths (paths from source to sink with available capacity) and increases the flow along these paths until no more augmenting paths exist.

// Consider a scenario where you need to find the maximum flow of traffic through a network of pipes or channels, such as water flowing through a network of pipes or cars travelling through roads.
// The Ford-Fulkerson algorithm can be used to determine this maximum flow.

import java.util.*;

public class FordFulkerson {
    static final int V = 6; // Number of vertices in the graph

    // Utility function to perform BFS and check if there is a path from source to sink
    boolean bfs(int[][] residualGraph, int source, int sink, int[] parent) {
        boolean[] visited = new boolean[V];
        Queue<Integer> queue = new LinkedList<>();
        queue.add(source);
        visited[source] = true;
        parent[source] = -1;

        while (!queue.isEmpty()) {
            int u = queue.poll();

            for (int v = 0; v < V; v++) {
                if (!visited[v] && residualGraph[u][v] > 0) {
                    if (v == sink) {
                        parent[v] = u;
                        return true;
                    }
                    queue.add(v);
                    parent[v] = u;
                    visited[v] = true;
                }
            }
        }
        return false;
    }


}