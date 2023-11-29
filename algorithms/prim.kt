// Prim's Algorithm is a greedy algorithm that finds a minimum spanning tree for a weighted undirected graph.
// It starts with a single vertex and continuously adds the lowest-weighted edge that connects a vertex in the tree to a vertex outside of the tree until all vertices are included.

// Imagine you're planning the layout of a network of roads to connect several towns.
// You want to minimize the total length of the roads while ensuring that all towns are connected.
// This is a case where Prim's Algorithm is useful: it finds a subset of the edges that forms a tree including every vertex, where the total weight of all the edges in the tree is minimized.

fun primsAlgorithm(graph: Array<IntArray>): Int {
    val numVertices = graph.size
    val inMST = BooleanArray(numVertices) { false }
    val key = IntArray(numVertices) { Int.MAX_VALUE }
    var totalWeight = 0

    key[0] = 0

    for (count in 0 until numVertices - 1) {
        val u = minKey(key, inMST)
        inMST[u] = true

        for (v in 0 until numVertices) {
            if (graph[u][v] != 0 && !inMST[v] && graph[u][v] < key[v]) {
                key[v] = graph[u][v]
            }
        }
    }

    key.forEach { totalWeight += it }
    return totalWeight
}
