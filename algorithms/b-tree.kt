// A B-tree is a self-balancing tree data structure that maintains sorted data and allows for efficient insertion, deletion, and searching operations.
// It is optimized for systems that read and write large blocks of data, makint it ideal for use in databases and file systems.

// Imagine you're designing a database management system for a large-scale e-commerce platform.
// Each product entry needs to be stored efficiently to enable fast searches, insertions, and deletions.
// The B-tree algorithm can efficiently organize and manage the product data, ensuring quick access to information even with millions of products.

class BTreeNode(private val t: Int, var leaf: Boolean = true) {
    val keys = mutableListOf<Int>()
    val children = mutableListOf<BTreeNode>()

    fun insertNonFull(key: Int) {
        var i = keys.size - 1
        if (leaf) {
            while (i >= 0 && keys[i] > key) {
                keys[i + 1] = keys[i]
                i--
            }
            keys[i + 1] = key
        } else {
            while (i >= 0 && keys[i] > key) {
                i--
            }
            if (children[i + 1].keys.size == 2 * t - 1) {
                splitChild(i + 1, children[i + 1])
                if (keys[i + 1] < key) {
                    i++
                }
            }
            children[i + 1].insertNonFull(key)
        }
    }
}