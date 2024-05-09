// Prim's Algorithm is for minimum spanning tree (MST) construction.
// Prim's algorithm is used to find the minimum spanning tree of a connected, undirected graph.
// It's efficient for dense graphs represented using adjacency matrices or priority queues.

// Imagine you have a city map where cities are nodes and roads between them are weighted edges.
// To minimize the total cost of constructing roads between all cities while ensuring all cities are connected,
// Prim's algorithm can determine the optimal road network.

import java.util.*;

class Prims {
    static class Edge {
        int dest;
        int weight;

        public Edge(int dest, int weight) {
            this.dest = dest;
            this.weight = weight;
        }
    }

    public static List<Edge>[] createGraph(int n) {
        List<Edge>[] graph = new List[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }
        return graph;
    }

    public static void addEdge(List<Edge>[] graph, int src, int desc, int weight) {
        graph[src].add(new Edge(dest, weight));
        graph[dest].add(new Edge(src, weight));
    }

    public static List<Edge> primMST(List<Edge>[] graph, int n) {
        List<Edge> mst = new ArrayList<>();
        boolean[] visited = new boolean[n];
        PriorityQueue<Edge> pq = new PriorityQueue<>(Comparator.comparingInt(e -> e.weight));

        // Start from vertex 0
        pq.add(new Edge(0, 0));

        while (!pq.isEmpty()) {
            Edge minEdge = pq.poll();
            int u = minEdge.dest;

            if (visited[u]) continue;
            visited[u] = true;
            mst.add(minEdge);

            for (Edge neighbor : graph[u]) {
                if (!visited[neighbor.dest]) {
                    pq.add(neighbor);
                }
            }
        }

        return mst;
    }

}