// Depth-First Search (DFS) is an algorithm used to traverse or search tree or graph data structures.
// The algorithm starts at the root node (or an arbitrary node for graphs) and explores as far as possible along each branch before backtracking.

// Supporse you're exploring a cave network. You start at the entrance and at each junction, you choose a tunnel to explore.
// You go as deep as you can, backtracking only when you reach a dead end.
// In computer science, this approach of exhaustive exploration is askin to the Depth-First Search algorithm.

class Graph(private val numVertices: Int) {
    private val adjList: MutableList<MutableList<Int>> = ArrayList()

    init {
        for (i in 0 until numVertices) {
            adjList.add(mutableListOf())
        }
    }

    fun addEdge(v: Int, w: Int) {
        adjList[v].add(w)
    }

    private fun DFSUtil(v: Int, visited: BooleanArray) {
        visited[v] = true
        print("$v ")

        for (i in adjList[v]) {
            if (!visited[i]) {
                DFSUtil(i, visited)
            }
        }
    }

    fun DFS(startingVertex: Int) {
        val visited = BooleanArray(numVertices)
        DFSUtil(startingVertex, visited)
    }
}

fun main() {
    val graph = Graph(4)

    graph.addEdge(0, 1)
    graph.addEdge(0, 2)
    graph.addEdge(1, 2)
    graph.addEdge(2, 0)
    graph.addEdge(2, 3)
    graph.addEdge(3, 3)

    println("Depth First Traversal starting from vertex 2:")
    graph.DFS(2)
}
