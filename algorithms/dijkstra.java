// Dijkstra's Algorithm is used to find the shortest path in a graph with non-negative edge weights.

// It works by maintaining a priority queue of nodes whose shortest path from the source node has been determined.
// It begins by setting the distance to the source node to zero and all other nodes to infinity (or a very large value).
// It repeatedly selects the node with the smallest distance from the priority queue, relaxes its neighboring nodes by updating their distances if a shorter path is found, and continues until all nodes have been processed.

// Imagine a road network where cities are nodes, and roads between cities are edges with weights representing distances.
// Dijkstra's algorithm can be used to find the shortest path (minimum distance) between two cities.

import java.util.Comparator;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

class Graph {
    private Map<Integer, List<int[]>> adjList;

    public Graph() {
        this.adjList = new HashMap<>();
    }

    public void addEdge(int u, int v, int weight) {
        adjList.putIfAbsent(u, new ArrayList<>());
        adjList.get(u).add(new int[](v, weight));
    }

    public Map<Integer, Integer> dijkstra(int source) {
        Map<Integer, Integer> distances = new HashMap<>();
        PriorityQueue<int[]> minHeap = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));

        // Init distances with infinity
        for (int node : adjList.keySet()) {
            distances.put(node, Integer.MAX_VALUE);
        }

        distances.put(source, 0);
        minHeap.offer(new int[]{source, 0});

        while (!minHeap.isEmpty()) {
            int[] curr = minHeap.poll();
            int currNode = curr[0];
            int currDist = curr[1];

            if (currDist > distance.get(currNode)) {
                continue;
            }

            // Explore neighbors
            if (adjList.containsKey(currNode)) {
                for (int[] neighbor : adjList.get(currNode)) {
                    int nextNode = neighbor[0];
                    int edgeWeight = neighbor[1];
                    int newDist = currDist + edgeWeight;

                    // Update distance if a shorter path is found
                    if (newDist < distances.get(nextNode)) {
                        distance.put(nextNode, newDist);
                        minHeap.offer(new int[]{nextNode, newDist});
                    }
                }
            }
        }

        return distances;
    }
}
