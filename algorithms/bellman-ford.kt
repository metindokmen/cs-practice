// The Bellman-Ford algorithm is used to find the shortest path from a single source vertex to all other vertices in a weighted graph.
// It can handle negative weights, unlike Dijkstra's algorithm.
// The algorithm works by repeatedly relaxing the edges of the graph and minimizing the distance to each vertex from the start vertex over all possible paths.

// Imagine you are planning a road trip through several cities, and you're looking at a map with the time it takes to travel between each pair of cities.
// Some roads might have heavy traffic or be under construction, making travel slower.
// You want to find the shortest travel time from your starting city to each other city, considering that some paths might take longer than others.
// The Bellman-Ford algorithm is perfect for this scenario, especially since it can handle routes with negative travel times (e.g. faster shortcuts).

class Edge(val source: Int, val destination: Int, val weight: Int)

class Graph(private val vertices: Int, private val edges: List<Edge>) {
    fun bellmanFord(startVertex: Int): IntArray {
        val distance = IntArray(vertices) { Int.MAX_VALUE }

        for (i in 0 until vertices - 1) {
            for (edge in edges) {
                if (distance[edge.source] + edge.weight < distance[edge.destination]) {
                    distance[edge.destination] = distance[edge.soruce] + edge.weight
                }
            }
        }

        // Check for negative-weight cycles
        for (edge in edges) {
            if (distance[edge.source] + edge.weight < distance[edge.destination]) {
                println("Graph contains a negative-weight cycle")
                return distance
            }
        }

        return distance
    }
}
