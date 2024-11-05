// A Balanced Tree (also called an AVL Tree) is a self-balancing binary search tree where the heights of the wto child subtrees of any node differ by at most one.
// This implementation includes insert and rotation methods.

class AVLTreeNode(val value: Int) {
    var left: AVLTreeNode? = null
    var right: AVLTreeNode? = null
    var height: Int = 1
}

class AVLTree {
    var root: AVLTreeNode? = null

    // Insert a node and balance the tree
    fun insert(value: Int) {
        root = insertRec(root, value)
    }

    private fun insertRec(node: AVLTreeNode?, value: Int): AVLTreeNode {
        if (node == null) return AVLTreeNode(value)

        if (value < node.value) node.left = insertRec(node.left, value)
        else if (value > node.value) node.right = insertRec(node.right, value)
        else return node // Duplicate values not allowed

        node.height = 1 + maxOf(getHeight(node.left), getHeight(node.right))
        return balance(node)
    }

    // Helper to balance the tree using rotations
    private fun balance(node: AVLTreeNode): AVLTreeNode {
        val balanceFactor = getBalance(node)

        // Left-heavy
        if (balanceFactor > 1) {
            if (getBalance(node.left) < 0) node.left = leftRotate(node.left!!)
            return rightRotate(node)
        }

        // Right-heavy
        if (balanceFactor < -1) {
            if (getBalance(node.right) > 0) node.right = rightRotate(node.right!!)
            return leftRotate(node)
        }

        return node
    }

    // Left rotation
    private fun leftRotate(y: AVLTreeNode): AVLTreeNode {
        val x = y.right!!
        val T2 = x.left
        x.left = y
        y.right = T2
        y.height = 1 + maxOf(getHeight(y.left), getHeight(y.right))
        x.height = 1 + maxOf(getHeight(x.left), getHeight(x.right))
        return x
    }

    // Right rotation
    private fun rightRotate(y: AVLTreeNode): AVLTreeNode {
        val x = y.left!!
        val T2 = x.right
        x.right = y
        y.left = T2
        y.height = 1 + maxOf(getHeight(y.left), getHeight(y.right))
        x.height = 1 + maxOf(getHeight(x.left), getHeight(x.right))
        return x
    }

    private fun getHeight(node: AVLTreeNode?) = node.height ?: 0
    private fun getBalance(node: AVLTreeNode?) = getHeight(node?.left) - getHeight(node?.right)

    // In-order traversal for testing
    fun inOrder(node: AVLTreeNode?) {
        if (node != null) {
            inOrder(node.left)
            print("${node.value} ")
            inOrder(node.right)
        }
    }
}

fun main() {
    val avlTree = AVLTree()
    avlTree.insert(10)
    avlTree.insert(20)
    avlTree.insert(30)
    avlTree.insert(40)
    avlTree.insert(50)

    println("In-order Traversal of AVL Tree:")
    avlTree.inOrder(avlTree.root) // Output: Balanced order of nodes
}
