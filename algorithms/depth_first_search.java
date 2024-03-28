// Depth First Search (DFS) is a graph traversal algorithm that explores as far as possible along each branch before backtracking.
// It is often used to traverse or search through trees or graphs.

// Consider a scenario where you are trying to navigate through a maze to find the exit.
// In this maze, you have multiple paths to choose from at each intersection.
// Depth First Search would involve exploring one path as far as possible before backtracking and exploring another path.

import java.util.*;

class Graph {
    private int V; // Number of vertices
    private LinkedList<Integer> adj[]; // Adjacency list representation

    Graph(int v) {
        V = v;
        adj = new LinkedList[v];
        for (int i = 0; i < v; i++) {
            adj[i] = new LinkedList();
        }
    }

    void addEdge(int v, int w) {
        adj[v].add(w);
    }

    // Depth First Search traversal starting from given vertex
    void DFSUtil(int v, boolean visited[]) {
        // Mark the current vertex as visited
        visited[v] = true;
        System.out.print(v + " ");

        // Recur for all vertices adjacent to this vertex
        Iterator<Integer> it = adj[v].iterator();
        while (it.hasNext()) {
            int n = it.next();
            if (!visited[n]) {
                DFSUtil(n, visited);
            }
        }
    }

    // Function to perform Depth First Search traversal
    void DFS(int v) {
        // Mark all the vertices as not visited(set as false by default in Java)
        boolean visited[] = new boolean[V];

        DFSUtil(v, visited);
    }
}
