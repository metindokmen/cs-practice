// Kruskal's Algorithm is a greedy algorithm that finds the minimum spanning tree for a connected weighted graph,
// meaning it finds a subset of the edges that forms a tree that includes every vertex, where the total weight of all the edges in the tree is minimized.

// Imagine a group of islands, and you're tasked with building bridges to connect all of them.
// Bridges have different costs based on the distance and difficulty of construction.
// Using Kruskal's Algorithm, you can find the most cost-effective way to connect all the islands without forming any cycles (loops).

data class Edge(val u: Int, val v: Int, val weight: Int)

fun find(parent: IntArray, i: Int): Int {
    if (parent[i] != i) {
        parent[i] = find(parent, parent[i])
    }
    return parent[i]
}

fun union(parent: IntArray, x: Int, y: Int) {
    val xRoot = find(parent, x)
    val yRoot = find(parent, y)
    parent[xRoot] = yRoot
}

fun kruskal(edges: List<Edge>, vertices: Int): List<Edge> {
    val result = mutableListOf<Edge>()
    val parent = IntArray(vertices) { it }
    edges.sortedBy { it.weight }.forEach { edge ->
        val x = find(parent, edge.u)
        val y = find(parent, edge.v)
        if (x != y) {
            result.add(edge)
            union(parent, x, y)
        }
    }
    return result
}

fun main() {
    val edges = listOf(
        Edge(0, 1, 10),
        Edge(0, 2, 6),
        Edge(0, 3, 5),
        Edge(1, 3, 15),
        Edge(2, 3, 4)
    )

    val mst = kruskal(edges, 4) // Minimum Spanning Tree
    mst.forEach { println("${it.u} - ${it.v} => ${it.weight}") }
}