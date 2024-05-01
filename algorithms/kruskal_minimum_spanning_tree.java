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
