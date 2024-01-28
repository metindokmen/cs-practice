// Karger's algorithm repeatedly contracts random edges in the graph until only two vertices remain.
// The remaining vertices represent the two parts of the cut.
// The algorithm has a high probability of finding the correct minimum cut.

// Consider a telecommunication network where you want to find the minimum number of links that need to be removed to disconnect the network into two parts.
// Karger's algorithm can help identify this minimum cut efficiently.

import kotlin.random.Random

class KargerMinCut(private val adjacencyList: Map<Int, MutableList<Int>>) {

    fun findMinCut(): Int {
        val vertices = adjacencyList.keys.toList()

        // Repeat the contraction process until only two vertices remain
        while (vertices.size > 2) {
            val v1 = vertices.random()
            val v2 = adjacencyList[v1]!!.random()

            contractEdge(v1, v2)
            vertices.remove(v2)
        }

        // Return the size of the cut
        return adjacencyList[vertices[0]]!!.size
    }
}