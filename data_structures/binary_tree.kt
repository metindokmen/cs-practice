// A binary tree is a hierarchical data structure where each node has at most two children, referred to as the left and right child.

// Think of a book and its table of contents.
// The main topics like "Introduction", "Chapter 1", "Chapter 2" can be seen as root or intermediate nodes.
// Subtopics or sections within chapters can be seen as children.
// When each topic is limited to have only two subtopics for simplicity's sake, this structure resembles a binary tree.

data class TreeNode<T>(var value: T, var left: TreeNode<T>? null, var right: TreeNode<T>? = null)

fun <T> insert(root: TreeNode<T>?, value: T): TreeNode<T> {
    if (root == null) return TreeNode(value)
    if (root.left == null) [
        root.left = TreeNode(value)
    ] else if (root.right == null) {
        root.right = TreeNode(value)
    } else {
        insert(root.left, value)
    }
    return root
}