// A Ternary Tree is a tree where each node has at most three children.

class TernaryTreeNode(val value: Int) {
    var left: TernaryTreeNode? = null
    var middle: TernaryTreeNode? = null
    var right: TernaryTreeNode? = null
}

class TernaryTree {
    var root: TernaryTreeNode? = null

    // Pre-order traversal: Node -> Left -> Middle -> Right
    fun preOrder(node: TernaryTreeNode?) {
        if (node != null) {
            print("${node.value} ")
            preOrder(node.left)
            preOrder(node.middle)
            preOrder(node.right)
        }
    }

    // Insert a new node into the ternary tree
    fun insert(value: Int) {
        if (root == null) {
            root = TernaryTreeNode(value)
        } else {
            insertRec(root, value)
        }
    }

    private fun insertRec(node: TernaryTreeNode?, value: Int): TernaryTreeNode {
        if (node == null) return TernaryTreeNode(value)

        if (node.left == null) node.left = TernaryTreeNode(value)
        else if (node.middle == null) node.middle = TernaryTreeNode(value)
        else if (node.right == null) node.right = TernaryTreeNode(value)
        else insertRec(node.left, value) // Keep adding to the left-most path if all are filled

        return node
    }
}
