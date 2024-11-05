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
}