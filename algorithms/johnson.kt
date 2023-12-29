// Johnson's Algorithm is used for finding the shortest paths between all pairs of vertices in a weighted, directed graph.
// It handles graphs with negative weights, provided they don't contain any negative weight cycles.
// The algorithm combines Bellman-Ford and Dijkstra's algorithms.
// It first uses Bellman-Ford to reweight edges to eliminate negative weights, then applies Dijkstra's algorithm for each vertex.
