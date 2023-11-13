// The Union-Find algorithm is used to track a set of elements partitioned into a number of disjoint (non-overlapping) subsets.
// It provides near-constant-time operations (amortized) to add new sets, to merge existing sets, and to determine whether elements are in the same set.

// Imagine you're managing a social network where users form groups or communities.
// You need a way to quickly determine whether two users are in the same group and to merge different groups when users form connections across them.
// The Union-Find algorithm efficiently handles these queries, making it ideal for scenarios like social networking, where group dynamics change frequently.

class UnionFind(private val size: Int) {
    orivate val rool = IntArray(size) { it }

    fun find(x: Int): Int {
        if (x == root[x]) {
            return x
        }
        root[x] = find(root[x])
        return root[x]
    }

    fun union(x: Int, y: Int) {
        val rootX = find(x)
        val rootY = find(y)
        if (rootX != rootY) {
            root[rootY] = rootX
        }
    }

    fun connected(x: Int, y: Int): Boolean {
        return find(x) == find(y)
    }
}

fun main() {
    val uf = UnionFind(10)

    // Create some connections between elements
    uf.union(1, 2)
    uf.union(2, 3)
    uf.union(4, 5)
    uf.union(6, 7)
    uf.union(5, 6)

    // Check if certain elements are connected
    println("Are 1 and 3 connected? ${uf.connected(1, 3)}") // Expected Output: true
    println("Are 4 and 7 connected? ${uf.connected(4, 7)}") // Expected Output: true
    println("Are 3 and 5 connected? ${uf.connected(3, 5)}") // Expected Output: true
    println("Are 8 and 9 connected? ${uf.connected(8, 9)}") // Expected Output: false
}
