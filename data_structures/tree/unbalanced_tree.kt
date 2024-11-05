// An unbalanced tree is a binary tree where no self-balancing mechanism is applied, leading to skewed structures.

class UnbalancedTreeNode(val value: Int) {
    var left: UnbalancedTreeNode? = null
    var right: UnbalancedTreeNode? = null
}

class UnbalancedTree {
    var root: UnbalancedTreeNode? = null

    // Insert a node (simple binary tree insertion without balancing)
    fun insert(value: Int) {
        root = insertRec(root, value)
    }

    private fun insertRec(node: UnbalancedTreeNode?, value: Int): UnbalancedTreeNode {
        if (node == null) return UnbalancedTreeNode(value)

        if (value < node.value) node.left = insertRec(node.left, value)
        else node.right = insertRec(node.right, value)

        return node
    }

    // In-order traversal to check structures
    fun inOrder(node: UnbalancedTreeNode?) {
        if (node != null) {
            inOrder(node.left)
            print("${node.value} ")
            inOrder(node.right)
        }
    }
}

fun main() {
    val unbalancedTree = UnbalancedTree()
    unbalancedTree.insert(10)
    unbalancedTree.insert(20)
    unbalancedTree.insert(30)
    unbalancedTree.insert(40)
    unbalancedTree.insert(50)

    println("In-order Traversal of Unbalanced Tree:")
    unbalancedTree.inOrder(unbalancedTree.root) // Output: 10 20 30 40 50 (Right-skewed)
}
