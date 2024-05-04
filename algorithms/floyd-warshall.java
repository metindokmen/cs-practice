// The Floyd-Warshal algorithm is used to find the shortest path between all pairs of vertices in a weighted graph, including negative edge weights (but no negative cycles).
// It computes the shortest paths in a dynamic programming manner by considering all possible paths through an intermediate vertex.

// Imagine a scenario where you need to find the shortest path between all pairs of cities in a transportation network, considering different direct routes between cities.
// The Floyd-Warshall algorithm can be used to compute these shortest paths efficently.

import java.util.Arrays;

public class FloydWarshall {

    public static void main(String[] args) {
        int INF = Intger.MAX_VALUE; // Infinity value for non-existent edges

        int[][] graph = {
                {0, INF, -2, INF},
                {4, 0 ,3, INF},
                {INF, INF, 0, 2},
                {INF, -1, INF, 0}
        };

        int n = graph.length;

        // Apply Floyd-Warshall algorithm
        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (graph[i][k] != INF && graph[k][j] != INF && graph[i][k] + graph[k][j] < graph[i][j]) {
                        graph[i][j] = graph[i][k] + graph[k][j];
                    }
                }
            }
        }

        // Print eht shortest distances between all pairs of vertices
        System.out.println("Shortest distances between all pairs of vertices:");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (graph[i][j] == INF) {
                    System.out.print("INF ");
                } else {
                    System.out.print(graph[i][j] + " ");
                }
            }
            System.out.println();
        }
    }
}
