// A graph is a collection of nodes (also called vertices) and edges that connect these nodes.
// Unlike trees, which have a strict hierarchical structure, graphs can be more flexible and represent different types of relationships.

// Key Terminology:
// 1. Vertex: A point in the graph.
// 2. Edge: A line connecting two vertices.
// 3. Adjacent: Two vertices are adjacent if they're connected by an edge.
// 4. Degree: The number of edges connected to a vertex.
// 5. Path: A sequence of vertices where each adjacent pair is connected by an edge.
// 6. Cycle: A path that starts and ends at the same vertex.
// 7. Directed Graph (aka Digraph): A graph where each edge has a direction.
// 8. Undirected Graph: A graph where edges have no direction.


// Think of a map of cities, where cities are vertices, and roads that connect them are edges.
// The graph can represent possible paths from one city to another.
// If one-way streets exist between cities, it's a directed graph.

// Example: Los Angeles an New York City are two nodes on the graph. Route 66 is the edge that connects them.

class Graph {
    val vertices: MutableMap<String, MutableList<String>> = mutableMapOf()

    fun addVertex(vertex: String) {
        vertices[vertex] = mutableListOf()
    }

    fun addEdge(vertex1: String, vertex2: String, bidirectional: Boolean = true) {
        vertices[vertex1]?.add(vertex2)
    }

    fun getAdjacents(vertex: String): List<String>? {
        return vertices[vertex]
    }
}

fun main() {
    val cityGraph = Graph()

    cityGraph.addVertex("Los Angeles")
    cityGraph.addVertex("New York City")
    cityGraph.addVertex("Denver")

    cityGraph.addEdge("Los Angeles", "Denver")
    cityGraph.addEdge("Denver", "New York City")

    println(cityGraph.getAdjacents("Los Angeles")) // Prints "Denver"
    println(cityGraph.getAdjacents("Denver")) // Prints ["Los Angeles", "New York City"]
}