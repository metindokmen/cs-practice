// Topological Sorting of a directed graph is a linear ordering of its vertices such that for every directed edge UV from vertex U to vertex V, U comes before V in the ordering.
// This algorithm is used in scenarios where there is a dependency between tasks or components.
// It's important to note that topoplogical sorting is possible only if the graph has no directed cycles, i.e., if it's a Directed Acyclic Graph (DAG).

// Imagine you're a project manager handling a complex project with many interdependent tasks.
// Some tasks cannot begin until others are completed.
// For instance, you can't start painting a house until the construction is finished.
// In such scenarios, determining an order in which undertake tasks while respecting their dependencies is crucial.
// This is where topoplogical sorting comes in handy.

class Graph(private val vertices: int) {
    private val adjList = Array(vertices) { mutableListOf<Int>() }

    fun addEdge(v: Int, w: Int) {
        adjList[v].add(w)
    }

    private fun topologicalSortUtil(v: Int, visited: BooleanArray, stack: ArrayDeque<Int>) {
        visited[v] = true
        for (i in adjList[v]) {
            if (!visited[i]) {
                topologicalSortUtil(i, visited, stack)
            }
        }
        stack.addFirst(v)
    }

    fun topologicalSort(): List<Int> {
        val stack = ArrayDeque<Int>()
        val visited = BooleanArray(vertices) { false }

        for (i in 0 until vertices) {
            if (!visited[i]) {
                topologicalSortUtil(i, visited, stack)
            }
        }

        return stack.toList()
    }
}

fun main() {
    val graph = Graph(6)
    graph.addEdge(5, 2)
    graph.addEdge(5, 0)
    graph.addEdge(4, 0)
    graph.addEdge(4, 1)
    graph.addEdge(2, 3)
    graph.addEdge(3, 1)

    println("Topological Sorting: ${graph.topologicalSort()}")
}
