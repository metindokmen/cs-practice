// Dijkstra's Algorithm is a graph search algorithm that solves the single-source shortest path problem for a graph with non-negative edge weights, producing the shortest path tree.
// This algorithm is often used in routing and as a subroutine in other graph algorithms.

// Imagine you're using a GPS navigation system to find the shortest path from your home to a destination in a city.
// The streets form a graph, and the driving time between intersections represent weights.
// Dijkstra's Algorithm can be used to determine the shortest time route to your destination, considering all possible paths.

data class Edge(val to: Int, val weight: Int)

fun dijkstra(graph: List<List<Edge>>, start: Int): IntArray {
    val n = graph.size
    val dist = IntArray(n) { Int.MAX_VALUE } // Distance values from the start
    val visited = BooleanArray(n) { false }

    dist[start] = 0

    for (i in 0 until n) {
        // Find the vertex with the minimum distance value from the unvisited vertices
        val u = (0 until n).filter { !visited[it] }.minByOrNull { dist[it] } ?: break

        // Mark the vertex as visited
        visited[u] = true

        // Update the distance value of the adjacent vertices
        for (edge in graph[u]) {
            val v = edge.to
            if (!visited[v] && dist[u] != Int.MAX_VALUE && dist[u] + edge.weight < dist[v]) {
                dist[v] = dist[u] + edge.weight
            }
        }
    }

    return dist
}

fun main() {
    val graph = listOf(
        listOf(Edge(1, 4), Edge(2, 2)), // Neighbors of node 0
        listOf(Edge(2, 5), Edge(3, 2)), // Neighbors of node 1
        listOf(Edge(3, 3)), // Neighbors of node 2
        listOf()
    )

    val distancesFromNode0 = dijkstra(graph, 0)
    println(distancesFromNode0.joinToString(", ")) // Output: 0, 4, 2, 5
}