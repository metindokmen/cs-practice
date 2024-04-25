// The Bellman-Ford algorithm works by iteratively relaxing edges in the graph.
// It starts by assuming an infinite distance for all vertices except the source vertex, which has a distance of 0.
// Then, it relaxes each edge repeatedly, updating the shortest known distance to each vertex until no more updates can be made.

// Imagine you are managing a transportation network where cities are connected by roads with different travel times.
// The Bellman-Ford algorithm can be used to determine the shortest travel times from a starting city to all other cities, considering possible delays or negative weights due to traffic conditions.
