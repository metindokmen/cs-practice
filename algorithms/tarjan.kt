// Tarjan's algorithm is used to find all SCCs in a directed graph. A SCC in a directed graph is a set of vertices where every vertex is reachable from every other vertex in the set.
// The algorithm uses depth-first search (DFS) and has a linear time complexity relative to the number of vertices and edges.

// Imagine a social network where each person is a node and friendships are directed edges (i.e., just because person A considers B a friend doesn't mean B considers A a friend).
// In this network, a group of people who are all mutually connected (directly or indirectly) forms a strongly connected component.
// Understanding these components can be crucial for features like group recommendations or targeted advertising.

class Graph(private val vertices: Int) {
    private val adjList = Array(vertices) { mutableListOf<Int>() }
    private var time = 0

    fun addEdge(v: Int, w: Int) {
        adjList[v].add(w)
    }

    private fun tarjanUtil(u: Int, low: IntArray, disc: IntArray, stackMember: BooleanArray, stack: ArrayDeque<Int>, scc: MutableList<MutableList<Int>>) {
        disc[u] = time
        low[u] = time
        time++
        stack.push(u)
        stackMember[u] = true

        for (v in adjList[u]) {
            if (disc[v] == -1) {
                tarjanUtil(v, low, disc, stackMember, stack, scc)
                low[u] = minOf(low[u], low[v])
            } else if (stackMember[v]) {
                low[u] = minOf(low[u], disc[v])
            }
        }

        var w = -1
        if (low[u] == disc[u]) {
            val component = mutableListOf<Int>()
            while (w != u) {
                w = stack.pop()
                component.add(w)
                stackMember[w] = false
            }
            scc.add(component)
        }
    }

    fun tarjanSCC(): List<List<Int>> {
        val low = IntArray(vertices)
        val disc = IntArray(vertices) { -1 }
        val stackMember = BooleanArray(vertices) { false }
        val stack = ArrayDeque<Int>()
        val scc = mutableListOf<MutableList<Int>>()

        for (i in 0 until vertices) {
            if (disc[i] == -1) {
                tarjanUtil(i, low, disc, stackMember, stack, scc)
            }
        }

        return scc
    }
}

fun main() {
    val g = Graph(5)
    g.addEdge(1, 0)
    g.addEdge(0, 2)
    g.addEdge(2, 1)
    g.addEdge(0, 3)
    g.addEdge(3, 4)

    val scc = g.tarjanSCC()
    println("Strongly Connected Components:")
    scc.forEach { component ->
        println(component.joinToString(", "))
    }
}
