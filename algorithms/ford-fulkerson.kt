// The Ford-Fulkerson algorithm computes the maximum flow in a flow network.
// It identifies possible paths from the source to the sink while incrementally increasing the flow along these paths.
// The algorithm continues until no more augmenting paths from the source to the sink are are available.
// The "augmenting path" is a path where the flow can be increased.

// Consider a network of water pipes connecting a reservoir to a village.
// Each pipe has a capacity limit, and you want to determine the maximum amount of water that can be transported from the reservoir to the village through this network of pipes.
// This is a classic example of a Maximum Flow Problem.

fun fordFulkerson(graph: Array<IntArray>, source: Int, sink: Int): Int {
    val residualGraph = graph.map { it.clone() }.toTypedArray()
    val parent = IntArray(graph.size) { -1 }
    var maxFlow = 0

    while (bfs(residualGraph, source, sink, parent)) {
        var pathFlow = Int.MAX_VALUE
        var s = sink
        while (s != source) {
            pathFlow = minOf(pathFlow, residualGraph[parent[s]][s])
            s = parent[s]
        }

        // Update residual capacities and reverse edges
        var v = sink
        while (v != source) {
            val u = parent[v]
            residualGraph[u][v] -= pathFlow
            residualGraph[v][u] += pathFlow
            v = parent[v]
        }

        maxFlow += pathFlow
    }
    return maxFlow
}

fun bfs(rGraph: Array<IntArray>, s: Int, t: Int, parent: IntArray): Boolean {
    val visited = BooleanArray(rGraph.size) { false }
    val queue = ArrayDeque<Int>()
    queue.add(s)
    visited[s] = true
    parent[s] = -1

    while (queue.isNotEmpty()) {
        val u = queue.removeFirst()

        for (v in rGraph.indices) {
            if (!visited[v] && rGraph[u][v] > 0) {
                queue.add(v)
                parent[v] = u
                visited[v] = true
            }
        }
    }
    return visited[t]
}

fun main() {
    val graph = arrayOf(
        intArrayOf(0, 16, 13, 0, 0, 0),
        intArrayOf(0, 0, 10, 12, 0, 0),
        intArrayOf(0, 4, 0, 0, 14, 0),
        intArrayOf(0, 0, 9, 0, 0, 20),
        intArrayOf(0, 0, 0, 7, 0, 4),
        intArrayOf(0, 0, 0, 0, 0, 0)
    )
    val source = 0
    val sink = 5
    println("The maximum possible flow is ${fordFulkerson(graph, source, sink)}")
}
