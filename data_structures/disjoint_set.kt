// A disjoint set is a data structure that keeps track of a partition of a set into disjoint subsets.
// It supports two main operations:

// 1. Union: Combine two subsets into a single subset.
// 2. Find: Determine which subset a particular element is in.

// Think of a social network platform where users can form groups.
// Every user starts as their own group.
// As users decide to merge their groups into larger communities, we need to be able to:
// a) combine two groups.
// b) check if two users are part of the same group.

class DisjointSet(size: Int) {
    private val parent = IntArray(size) { it } // Every element is its own parent at first.
    private val rank = IntArray(size)

    fun find(x: Int): Int {
        if (parent[x] != x) {
            parent[x] = find(parent[x]) // Path comparison
        }
        return parent[x]
    }

    fun union(x: Int, y: Int): Boolean {
        val rootX = find(x)
        val rootY = find(y)

        if (rootX == rootY) return false // Already in the same set

        // Union by rank
        if (rank[rootX] < rank[rootY]) {
            parent[rootX] = rootY
        } else if (rank[rootX] > rank[rootY]) {
            parent[rootY] = rootX
        } else {
            parent[rootY] = rootX
            rank[rootX]++
        }
        return true
    }
}

fun main() {
    val ds = DisjointSet(5)

    ds.union(0, 1)
    ds.union(2, 3)
    ds.union(3, 4)

    println(dis.find(0) == ds.find(1)) // Output: true
    println(ds.find(1) == ds.find(2)) // Output: false
    println(ds.find(2) == ds.find(4)) // Output: true
}