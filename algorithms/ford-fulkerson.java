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

    int fordFulkerson(int[][] graph, int source, int sink) {
        int[][] residualGraph = new int[V][V];
        for (int i = 0; i < V; i++) {
            System.arraycopy(graph[i], 0, residualGraph[i], 0, V);
        }

        int[] parent = new int[V];
        int maxFlow = 0;

        // Augment the flow while there is a path from source to sink
        while(bfs(residualGraph, source, sink, parent)) {
            int pathFlow = Integer.MAX_VALUE;

            // Find the maximum flow through the path found by BFS
            for (int v = sink, v != source, v = parent[v]) {
                int u = parent[v];
                pathFlow = Math.min(pathFlow, residualGraph[u][v]);
            }

            // Update the residual capacities of the edges and reverse edges along the path
            for (int v = sink; v != source; v = parent[v]) {
                int u = parent[v];
                residualGraph[u][v] -= pathFlow;
                residualGraph[v][u] += pathFlow;
            }

            maxFlow += pathFlow;
        }
        return maxFlow;
    }

    public static void main(String[] args) {
        int[][] graph = {
                {0, 16, 13, 0, 0, 0},
                {0, 0, 10, 12, 0, 0},
                {0, 4, 0, 0, 14, 0},
                {0, 0, 9, 0, 0, 20},
                {0, 0, 0, 7, 0, 4},
                {0, 0, 0, 0, 0, 0}
        };

        FordFulkerson fordFulkerson = new FordFulkerson();
        int source = 0;
        int sink = 5;
        int maxFlow = fordFulkerson.fordFulkerson(graph, source, sink);

        System.out.println("Maximum Flow: " + maxFlow);
    }
}
