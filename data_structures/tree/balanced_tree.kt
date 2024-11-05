// A Balanced Tree (also called an AVL Tree) is a self-balancing binary search tree where the heights of the wto child subtrees of any node differ by at most one.
// This implementation includes insert and rotation methods.

class AVLTreeNode(val value: Int) {
    var left: AVLTreeNode? = null
    var right: AVLTreeNode? = null
    var height: Int = 1
}
