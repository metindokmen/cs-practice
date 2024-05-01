// Kurskal's algorithm is a greedy algorithm that constructs a Minimum Spanning Tree (MST) for a connected weighted graph.
// The MST is a subset of the edges of the graph that connects all the vertices together without any cycles and with the minimum total edge weight.

// Steps:
// 1. Sort Edges: Sort all edges in non-decreasing order of their weight.
// 2. Initialize MST: Create an empty graph `MST` that will eventually form the MST.
// 3. Union-Find Data Structure: Use a Union-Find data structure to keep track of connected components.
// 4. Iterate Over Edges: For each edge (sorted by weight):
// - If adding the edge to `MST` doesn't form a cycle (i.e., the edge connects two different components), add it to `MST`
// 5. Final MST: The `MST` will contain the minimum set of edges that connect all the vertices with the minimum total weight.

// Imagine you have a network of cities connected by roads, each road having a certain construction cost.
// Kruskal's algorithm can be used to find the minimum cost to connect all cities with roads, ensuring that each city is reachable.

import java.util.*;

class Edge implements Comparable<Edge> {
    int src, dest, weight;

    Edge(int src, int dest, int weight) {
        this.src = src;
        this.dest = dest;
        this.weight = weight;
    }

    @Override
    public int compareTo(Edge other) {
        return this.weight - other.weight;
    }
}

class UnionFind {
    int[] parent, rank;

    UnionFind(int n) {
        parent = new int[n];
        rank = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
            rank[i] = 0;
        }
    }

    int find(int u) {
        if (parent[u] != u) {
            parent[u] = find(parent[u]);
        }
        return parent[u];
    }

    void union(int u, int v) {
        int rootU = find(u);
        int rootV = find(v);

        if (rootU != rootV) {
            if (rank[rootU] > rank[rootV]) {
                parent[rootV] = rootU;
            } else if (rank[rootU] < rank[rootV]) {
                parent[rootU] = rootV;
            } else {
                parent[rootV] = rootU;
                rank[rootU]++;
            }
        }
    }
}

public class KruskalAlgorithm {

    public static List<Edge> kruskalMST(List<Edge> edges, int n) {
        List<Edge> mst = new ArrayList<>();
        UnionFind uf = new UnionFind(n);
        Collections.sort(edges);

        for (Edge edge : edges) {
            int src = edge.src;
            int dest = edge.dest;

            if (uf.find(src) != uf.find(dest)) {
                uf.union(src, dest);
                mst.add(edge);
            }

            // Early exit if MST is complete (n-1 edges)
            if (mst.size() == n - 1) {
                break;
            }
        }

        return mst;
    }

    public static void main(String[] args) {
        List<Edge> edges = new ArrayList<>();
        edges.add(new Edge(0, 1, 4));
        edges.add(new Edge(0, 7, 8));
        edges.add(new Edge(1, 2, 8));
        edges.add(new Edge(1, 7, 11));
        edges.add(new Edge(2, 3, 7));
        edges.add(new Edge(2, 5, 4));
        edges.add(new Edge(2, 8, 2));
        edges.add(new Edge(3, 4, 9));
        edges.add(new Edge(3, 5, 14));
        edges.add(new Edge(4, 5, 10));
        edges.add(new Edge(5, 6, 2));
        edges.add(new Edge(6, 7, 1));
        edges.add(new Edge(6, 8, 6));
        edges.add(new Edge(7, 8, 7));

        List<Edge> mst = kruskalMST(edges, 9);

        System.out.println("Minimum Spanning Tree (MST):");
        for (Edge edge : mst) {
            System.out.println(edge.src + " - " + edge.dest + " : " + edge.weight);
        }
    }
}
