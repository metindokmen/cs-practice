// Breadth-First Search (BFS) is an algorithm for traversing or searching tree or graph data structures.
// It starts at the tree root (or an abtirary node of a graph) and explores the neighbor nodes at the current depth prior to moving on to nodes at the next depth level.

// Imagine you're playing a game where you're in a large maze and you need to find the shortest path to the exit.
// The maze can be visualized as a graph where each room is a node, and each door connecting two rooms is an edge.
// By using BFS, starting from your current room, you'd first explore all the immediate neighboring rooms, then the neighbors of those neighbors, and so on, until you find the exit.
// This ensures you find the shortest path to the exit.

import java.util.LinkedList
import java.util.Queue

class Graph(private val numVertices: Int) {
    private val adjList = MutableList<MutableList<Int>> = ArrayList()

    init {
        for (i in 0 until numVertices) {
            adjList.add(mutableListOf())
        }
    }

    fun addEdge(v: Int, w: Int) {
        adjList[v].add(w)
    }

    fun BFS(startingVertex: Int) {
        val visited = BooleanArray(numVertices)
        val queue: Queue<Int> = LinkedList()

        visited[startingVertex] = true
        queue.add(startingVertex)

        while (queue.isNotEmpty()) {
            val currentIndex = queue.poll()
            print("$currentIndex")

            for (i in adjList[currentVertex]) {
                if (!visited[i]) {
                    visited[i] = true
                    queue.add(i)
                }
            }
        }
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

    println("Breadth First Traversal starting from vertex 2:")
    graph.BFS(2)
}