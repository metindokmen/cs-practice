// A Binary Search Tree is a Binary Tree with an ordering property: left child < parent < right child

class BinarySearchTreeNode(val value: Int) {
    var left: BinarySearchTreeNode? = null
    var right: BinarySearchTreeNode? = null
}

class BinarySearchTree {
    var root: BinarySearchTreeNode? = null

    // Insert a new node into the BST
    fun insert(value: Int) {
        root = insertRec(root, value)
    }

    private fun insertRec(node: BinarySearchTreeNode?, value: Int): BinarySearchTreeNode {
        if (node == null) return BinarySearchTreeNode(value)

        if (value < node.value) node.left = insertRec(node.left, value)
        else if (value > node.value) node.right = insertRec(node.right, value)
        return node
    }

    fun search(value: Int): Boolean {
        return searchRec(root, value) != null
    }

    private fun searchRec(node: BinarySearchTreeNode?, value: Int): BinarySearchTreeNode {
        if (node == null || node.value == value) return node

        return if (value < node.value) searchRec(node.left, value)
        else searchRec(node.right, value)
    }

    // In-order traversal: Left -> Node -> Right
    fun inOrder(node: BinarySearchTreeNode?) {
        if (node != null) {
            inOrder(node.left)
            print("${node.value} ")
            inOrder(node.right)
        }
    }
}

fun main() {
    val bst = BinarySearchTree()
    bst.insert(10)
    bst.insert(5)
    bst.insert(15)
    bst.insert(2)
    bst.insert(7)

    println("In-order Traversal")
    bst.inOrder(bst.root) // Output: 2 5 7 10 15
    println("\nSearch for 7: ${bst.search(7)}") // Output: true
    println("Search for 12: ${bst.search(12)}") // Output: false
}
