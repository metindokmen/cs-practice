// The Bellman-Ford algorithm works by iteratively relaxing edges in the graph.
// It starts by assuming an infinite distance for all vertices except the source vertex, which has a distance of 0.
// Then, it relaxes each edge repeatedly, updating the shortest known distance to each vertex until no more updates can be made.

// Imagine you are managing a transportation network where cities are connected by roads with different travel times.
// The Bellman-Ford algorithm can be used to determine the shortest travel times from a starting city to all other cities, considering possible delays or negative weights due to traffic conditions.

import java.util.*;

class Edge {
    int src, dest, weight;
    Edge(int src, int dest, int weight) {
        this.src = src;
        this.dest = dest;
        this.weight = weight;
    }
}

public class BellmanFordAlgorithm {
    public static void bellmanFord(List<Edge> edges, int V, int source) {
        int[] dist = new int[V];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[source] = 0;

        // Relax edges |V| - 1 times
        for (int i = 0; i < V - 1; i++) {
            for (Edge edge : edges) {
                if (dist[edge.src] != Integer.MAX_VALUE && dist[edge.src] + edge.weight < dist[edge.dest]) {
                    dist[edge.dest] = dist[edge.src] + edge.weight;
                }
            }
        }

        for (Edge edge : edges) {
            if (dist[edge.src] != Integer.MAX_VALUE && dist[edge.src] + edge.weight < dist[edge.dest]) {
                System.out.println("Graph contains negative weight cycle!");
                return;
            }
        }

        for (int i = 0; i < V; i++) {
            System.out.println("Shortest distance from source to vertex " + i + ": " + dist[i]);
        }
    }
    public static void main(String[] args) {
        int V = 5; // Number of vertices
        int source = 0; // Source vertex
        List<Edge> edges = new ArrayList<>();
        edges.add(new Edge(0, 1, 6));
        edges.add(new Edge(0, 2, 7));
        edges.add(new Edge(1, 2, 8));
        edges.add(new Edge(1, 3, -4));
        edges.add(new Edge(1, 4, 5));
        edges.add(new Edge(2, 3, 9));
        edges.add(new Edge(2, 4, -3));
        edges.add(new Edge(3, 1, 7));
        edges.add(new Edge(4, 0, 2));
        edges.add(new Edge(4, 3, 7));

        bellmanFord(edges, V, source);
    }
}
