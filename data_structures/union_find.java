// A Disjoin Set Union (DSU) or Union-Find is a data structure that keeps track of a set of elements partitioned into a number of disjoint (non-overlapping) subsets.
// It suppors two primary operations efficiently:

// 1. Find: Determine the subset a particular element is in.
// 2. Union: Merge two subsets into a single subset.

// Consider a social network where each person is a node, and friendships are edges.
// We want to determine if two people are in the same friendship group (connected component) or merge two groups when a new friendship is formed.
// The Union-Find data structure efficently handles these operations.

class UnionFind {
    private in[] parent;
    private int[] rank;

    // Construcotr to initialize n elements with each element in its own set
    public UnionFind(int n) {
        parent = new int[n];
        rank = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
            rank[i] = 0;
        }
    }

    // Find the representative (root) of the set that element x belongs to
    public int find(int x) {
        if (parent[x] != x) {
            parent[x] = find(parent[x]); // Path compression
        }
        return parent[x];
    }

    // Union of two sets containing elements x and y
    public void union(int x, int y) {
        int rootX = find(x);
        int rootY = find(y);

        if (rootX != rootY) {
            // Union by rank
            if (rank[rootX] > rank[rootY]) {
                parent[rootY] = rootY;
            } else if (rank[rootX] < rank[rootY]) {
                parent[rootX] = rootY;
            } else {
                parent[rootY] = rootX;
                rank[rootX]++;
            }
        }
    }

    public boolean connected(int x, int y) {
        return find(x) == find(y);
    }
}

