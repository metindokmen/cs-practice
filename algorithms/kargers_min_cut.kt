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

    private fun contractEdge(v1: Int, v2: Int) {
        val neighborsV1 = adjacencyList[v1]!!
        val neighborsV2 = adjacencyList[v2]!!

        // Merge the neighbors of v2 into v1
        neighborsV1.addAll(neighborsV2)
        neighborsV1.remove(v2)

        // Replace occurrences of v2 with v1 in other vertices' neighbor lists
        for (neighbor in neighborsV2) {
            adjacencyList[neighbor]!!.apply {
                removeAll { it == v2 }
                add(v1)
            }
        }

        // Remove self-loops
        neighborsV1.removeAll { it == v1 }
        adjacencyList.remove(v2)
    }
}
