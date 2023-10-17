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

fun main() {
    val INF = Int.MAX_VALUE
    val graph = arrayOf(
        intArrayOf(0, 3, INF, 5),
        intArrayOf(2, 0, 3, INF),
        intArrayOf(INF, INF, 0, 7),
        intArrayOf(6, 8, INF, 0)
    )

    val distanceMatrix = floydWarshall(graph)
    for (i in distanceMatrix.indices) {
        for (j in distanceMatrix[i].indices) {
            if (distanceMatrix[i][j] == INF) {
                print("INF ")
            } else {
                print("${distanceMatrix[i][j]}")
            }
        }
        println()
    }
}
