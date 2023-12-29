// Johnson's Algorithm is used for finding the shortest paths between all pairs of vertices in a weighted, directed graph.
// It handles graphs with negative weights, provided they don't contain any negative weight cycles.
// The algorithm combines Bellman-Ford and Dijkstra's algorithms.
// It first uses Bellman-Ford to reweight edges to eliminate negative weights, then applies Dijkstra's algorithm for each vertex.

// Imagine you're developing a navigation app that suggests the shortest routes in a city with one-way streets (directed graph).
// Some streets have time-based restrictions (negative weights), like faster movement during non-peak hours.
// However, you want to avoid routes that have a total negative weight to prevent infinite loops (negative weight cycles).
// Johnson's Algorithm can efficiently find the shortest paths between all pairs of vertices in such a weighted graph, even with some negative weights.
