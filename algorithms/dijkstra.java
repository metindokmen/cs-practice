// Dijkstra's Algorithm is used to find the shortest path in a graph with non-negative edge weights.

// It works by maintaining a priority queue of nodes whose shortest path from the source node has been determined.
// It begins by setting the distance to the source node to zero and all other nodes to infinity (or a very large value).
// It repeatedly selects the node with the smallest distance from the priority queue, relaxes its neighboring nodes by updating their distances if a shorter path is found, and continues until all nodes have been processed.

// Imagine a road network where cities are nodes, and roads between cities are edges with weights representing distances.
// Dijkstra's algorithm can be used to find the shortest path (minimum distance) between two cities.
