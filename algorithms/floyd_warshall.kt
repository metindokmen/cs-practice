// The Floyd-Warshall algorithm is used to find the shortest paths in a weighted graph with positive or negative edge weights (but with no negative cycles).
// It works by considering all pairs of nodes and systematically trying all possible paths between each pair to find the shortest.

// Imagine you're operating a travel agency and you want to determine the shortest paths between all pairs of cities you service, considering all possible routes and modes of transportation.
// The Floyd-Warshall algorithm can help you find these shortest paths between every pair of cities, even if they don't have a direct connection.

fun floydWarshall(graph: Array<IntArray>): Array<IntArray> {
    val numVertices = graph.size
    val distance = Array(numVertices) { IntArray(numVertices) }

    for (i in 0 until numVertices) {
        for (j in 0 until numVertices) {
            distance[i][j] = graph[i][j]
        }
    }

    for (k in 0 until numVertices) {
        for (i in 0 until numVertices) {
            for (j in 0 until numVertices) {
                if (distancep[i][k] + distance[k][j] < distance[i][j]) {
                    distance[i][j] = distance[i][k] + distance[k][j]
                }
            }
        }
    }

    return distance
}
