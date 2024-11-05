// A Binary Tree is a tree where each node has at most two children.

class BinaryTreeNode(val value: Int) {
    var left: BinaryTreeNode? = null
    var right: BinaryTreeNode? = null
}

class BinaryTree {
    var root: BinaryTreeNode? = null

    // In-order traversal: Left -> Node -> Right
    fun inOrder(node: BinaryTreeNode?) {
        if (node != null) {
            inOrder(node.left)
            print("${node.value} ")
            inOrder(node.right)
        }
    }

    // Insert into Binary Tree (not necessarily a Binary Search Tree)
    fun insert(value: Int) {
        root = insertRec(root, value)
    }

    private fun insertRec(node: BinaryTreeNode?, value: Int): BinaryTreeNode {
        if (node == null) return BinaryTreeNode(value)

        if (node.left == null) node.left = insertRec(node.left, value)
        else node.right = insertRec(node.right, value)
        return node
    }
}
