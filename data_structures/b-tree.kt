// B-Tree is a balanced tree data structure commonly used in database systems and file systems for efficient storage and retrieval of data.

// 1. Concept: A B-Tree is a self-balancing tree data structure that maintains sorted data and allows for efficient insertion, deletion, and search operations.
// It is designed to work well with secondary storage devices like hard drives and SSDs.

// 2. Properties:
// - Each node in B-Tree can have multiple children.
// - Nodes are kept balanced by ensuring that every leaf node is at the same level.
// - All nodes (except the root) have at least t-1 keys and at most 2t-1 keys, where t is the minimum degree of the B-Tree.
// - Keys within a node are stored in sorted order, enabling efficient search operations using binary search.

// 3. Operations:
// - Insertion: When inserting a new key, the B-Tree ensures that the tree remains balanced by splitting nodes if necessary.
// - Deletion: Deleting a key from a B-Tree involves finding the key and removing it while maintaining the tree's balance.
// - Search: Searching for a key in a B-Tree follows a similar process to searching in a binary search tree, but it traverses multiple levels of the tree to find the key.

class BTreeNode<T: Comparable<T>>(val leaf: Boolean) {
    val keys = mutableListOf<T>()
    val children = mutableListOf<BTreeNode<T>>()
}

class BTree<T: Comparable<T>>(private val t: Int) {
    private var root: BTreeNode<T>? = null

    fun search(key: T): Boolean {
        return search(root, key)
    }

    private fun search(node: BTreeNode<T>?, key: T): Boolean {
        if (node == null) return false
        var i = 0
        while (i < node.keys.size && key > node.keys[i]) {
            i++
        }
        return when {
            i < node.keys.size && key == node.keys[i] -> true
            node.leaf -> false
            else -> search(node.children[i], key)
        }
    }

    fun insert(key: T) {
        if (root == null) {
            root = BTreeNode<T>(true)
            root!!.keys.add(key)
        } else {
            val r = root
            if (r!!.keys.size == 2 * t - 1) {
                val s = BTreeNode<T>(false)
                root = s
                s.children.add(r)
                splitChild(s, 0)
                insertNonFull(s, key)
            } else {
                insertNonFull(r, key)
            }
        }
    }

    private fun insertNonFull(node: BTreeNode<T>?, key: T) {
        var i = node!!.keys.size - 1
        if (node.leaf) {
            while (i >= 0 && key < node.keys[i]) {
                i--
            }
            node.keys.add(i + 1, key)
        } else {
            while (i >= 0 && key < node.keys[i]) {
                i--
            }
            i++
            if (node.children[i]!!.keys.size == 2 * t - 1) {
                splitChild(node, i)
                if (key > node.keys[i]) {
                    i++
                }
            }
            insertNonFull(node.children[i], key)
        }
    }

}