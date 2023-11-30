// In graph theory, a biconnected component (BCC) of a graph is a maximal set of edges such that any two edges are connected to each other by a path of edges which does not pass through the same vertex more than once.
// If a single vertex (called an articulation point or cut vertex) is removed, the BCC will not be disconnected.
// The algorithm typically uses depth-first search (DFS) to find these components.

// Imagine you are analyzing a road network to identify critical junctions or intersections.
// In such a network, a biconnected component is a set of roads and junctions with the property that removing any single junction (and its associated roads) does not disconnect the network.
// Identifying these components helps in urban planning, especially in understanding the resilience of the road network and pinpointing critical points whose failure could cause significant disruption.

class Graph(private val V: int) {
    private val adj: MutableList<MutableList<Int>> = MutableList(V) { mutableListOf() }
    private var time = 0

    fun addEdge(v: Int, w: Int) {
        adj[v].add(w)
        adj[w].add(v)
    }

    private fun APUtil(u: Int, visited: BooleanArray, disc: IntArray, low: IntArray, parent: IntArray, ap: BooleanArray) {
        var children = 0
        visited[u] = true
        disc[u] = time
        low[u] = time
        time += 1

        for (v in adj[u]) {
            if (!visited[v]) {
                children++
                parent[v] = u
                APUtil(v, visited, disc, low, parent, ap)

                low[u] = minOf(low[u], low[v])

                if (parent[u] == -1 && children > 1) {
                    ap[u] = true
                }

                if (parent[u] != -1 && low[v] >= disc[u]) {
                    ap[u] = true
                }
            } else if (v != parent[u]) {
                low[u] = minOf(low[u], disc[v])
            }
        }
    }

    fun findAP() {
        val visited = BooeleanArray(V)
        val disc = IntArray(V)
        val low = IntArray(V)
        val parent = IntArray(V) { -1 }
        val ap = BooleanArray(V)

        for (i in 0 until V) {
            if (!visited[i]) {
                APUtil(i, visited, disc, low, parent, ap)
            }
        }

        for (i in 0 until V) {
            if (ap[i]) {
                println("$i ")
            }
        }
    }
}
