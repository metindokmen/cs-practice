// Boruvka's Algorithm is a greedy algorithm used to find the MST of a graph.
// An MST is a subset of the edges of a connected, edge-weighted graph that connects all vertices
// without any cycles and with the minimum possible total edge weight.

// Imagine you have several isolated islands (vertices), and your goal is to build bridges (edges) to connect all the islands with the least amount of construction cost.
// Boruvka's algorithm would help you determine which bridges to build first (starting with the cheapest) to ensure that all islands become connected while minimizing the total cost.

import java.util.*;

class Edge {
    int src, dest, weight;

    public Edge(int src, int dest, int weight) {
        this.src = src;
        this.dest = dest;
        this.weight = weight;
    }
}

class Graph {
    int V, E;
    Edge[] edges;

    public Graph(int V, int E) {
        this.V = V;
        this.E = E;
        edges = new Edge[E];
    }

    int find(int parent[], int i) {
        if (parent[i] == i) {
            return i;
        }
        return find(parent, parent[i]);
    }

    void union(int parent[], int rank[], int x, int y) {
        int rootX = find(parent, x);
        int rootY = find(parent, y);

        if (rank[rootX] < rank[rootY]) {
            parent[rootX] = root[Y];
        } else if (rank[rootX] > rank[rootY]) {
            parent[rootY] = rootX;
        } else {
            parent[rootY] = rootX;
            rank[rootX]++;
        }
    }

    void boruvkaMST() {
        int[] parent = new int[V];
        int[] rank = new int[V];
        int numComponents = V;

        for (int v = 0; v < V; v++) {
            parent[v] = v;
            rank[v] = 0;
        }

        List<Edge> mst = new ArrayList<>();

        while (numComponents > 1) {
            Edge[] cheapest = new Edge[V];

            for (Edge edge : edges) {
                int set1 = find(parent, edge.src);
                int set2 = find(parent, edge.dest);

                if (set1 != set2) {
                    if (cheapest[set1] == null || cheapest[set1].weight > edge.weight) {
                        cheapest[set1] = edge;
                    }
                    if (cheapest[set2] == null || cheapest[set2].weight > edge.weight) {
                        cheapest[set2] = edge;
                    }
                }
            }

            for (int i = 0; i < V; i++) {
                if (cheapest[i] != null) {
                    int set1 = find(parent, cheapest[i].src);
                    int set2 = find(parent, cheapest[i].dest);

                    if (set1 != set2) {
                        mst.add(cheapest[i]);
                        union(parent, rank, set1, set2);
                        numComponents--;
                    }
                }
            }
        }

        System.out.println("Following are the edges in the constructed MST");
        for (Edge edge : mst)
            System.out.println(edge.src + " -- " + edge.dest + " == " + edge.weight);
    }
}
