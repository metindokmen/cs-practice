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
