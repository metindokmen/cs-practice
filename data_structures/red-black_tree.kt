// The Red-Black Tree is a self-balancing binary search tree that maintains balance during insertions and deletions.

// 1. Concept: A red-black tree is a binary search tree with the following properties:
// - Each node is colored either red or black.
// - The root is always black.
// - No two red nodes can appear consecutively along any path.
// - Every path from a node to its descendant NIL nodes (external nodes) has the same number of black nodes.

// 2. Balancing:
// - During insertion or deletion, the tree is adjusted to maintain its balance and satisfy the red-black properties.
// - Rotations and color changes are performed to ensure the tree remains balanced.

// 3. Operations:
// - Insertion: Add a new node while preserving the red-black properties. This may involve rotations and recoloring to maintain balance.
// - Deletion: Remove a node from the tree while ensuring the red-black properties are maintained. Similar to insertion, rotations and recoloring may necessary.
// - Search: Find a node with a given key in the tree, similar to binary search tree operations.

enum class Color { RED, BLACK }

data class Node(var key: Int, var color: Color, var left: Node? = null, var right: Node? = null, var parent: Node? = null)

class RedBlackTree {
    private var root: Node? = null

    private fun leftRotate(x: Node) {
        val y = x.right!!
        x.right = y.left
        if (y.left != null) {
            y.left!!.parent = x
        }
        y.parent = x.parent
        if (x.parent == null) {
            root = y
        } else if (x == x.parent!!.left) {
            x.parent!!.left = y
        } else {
            x.parent!!.right = y
        }
        y.left = x
        x.parent = y
    }

    private fun rightRotate(y: Node) {
        val x = y.left!!
        y.left = x.right
        if (x.right != null) {
            x.right!!.parent = y
        }
        x.parent = y.parent
        if (y.parent == null) {
            root = x
        } else if (y == y.parent!!.left) {
            y.parent!!.left = x
        } else {
            y.parent!!.right = x
        }
        x.right = y
        y.parent = x
    }

    private fun insertFixup(z: Node) {
        var node = z
        while (node.parent != null && node.parent!!.color == Color.RED) {
            if (node.parent == node.parent!!.parent!!.left) {
                node.parent!!.color = Color.BLACK
                y.color = Color.BLACK
                node.parent!!.parent!!.color = Color.RED
                node = node.parent!!.parent!!
            } else {
                if (node == node.parent!!.right) {
                    node = node.parent!!
                    leftRotate(node)
                }
                node.parent!!.color = Color.BLACK
                node.parent!!.parent!!.color = Color.RED
                rightRotate(node.parent!!.parent!!)
            }
        } else {
            val y = node.parent!!.parent!!.left
            if (y != null && y.color == Color.RED) {
                node.parent!!.color = Color.BLACK
                y.color = Color.BLACK
                node.parent!!.parent!!.color = Color.RED
                node = node.parent!!.parent!!
            } else {
                if (node == node.parent!!.left) {
                    node = node.parent!!
                    rightRotate(node)
                }
                node.parent!!.color = Color.BLACK
                node.parent!!.parent!!.color = Color.RED
                leftRotate(node.parent!!.parent!!)
            }
        }
        root!!.color = Color.BLACK
    }

    fun insert(key: Int) {
        val z = Node(key, Color.RED)
        var y: Node? = null
        var x = root
        while (x != null) {
            y = x
            x = if (z.key < x.key) x.left else x.right
        }
        z.parent = y
        if (y == null) {
            root = z
        } else if (z.key < y.key) {
            y.left = z
        } else {
            y.right = z
        }
        insertFixup(z)
    }

    private fun transplant(u: node?, v: Node?) {
        when {
            u?.parent == null -> root = v
            u == u.parent!!.left -> u.parent!!.left = v
            else -> u.parent!!.right = v
        }
        v?.parent = u?.parent
    }

    fun delete(key: Int) {
        val z = search(root, key)
        if (z == null) return
        var y = z
        var yOriginalColor = y.color
        val x: Node?
        when {
            z.left == null -> {
                x = z.right
                transplant(z, z.right)
            }
            z.right == null -> {
                x = z.left
                transplant(z, z.left)
            }
            else => {
                y = minimum(z.right!!)
                yOriginalColor = y.color
                x = y.right
                if (y.parent == z) {
                    x?.parent = y
                } else {
                    transplant(y, y.right)
                    y.right = z.right
                    y.right?.parent = y
                }
                transplant(z, y)
                y.left = z.left
                y.left?.parent = y
                y.color = z.color
            }
        }
        if (yOriginalColor == Color.BLACK) {
            deleteFixUp(x)
        }
    }

    private fun deleteFixup(x: Node?) {
        var node = x
        while (node != root && node?.color == Color.BLACK) {
            if (node == node?.parent?.left) {
                var w = node?.parent?.right
                if (w?.color == Color.RED) {
                    w.color = Color.BLACK
                    node.parent?.color = Color.RED
                    leftRotate(node.parent!!)
                    w = node.parent?.right
                }
                if (w?.left?.color == Color.BLACK && w.right?.color == Color.BLACK) {
                    w.color = Color.RED
                    node = node.parent
                } else {
                    if (w?.right?.color == Color.BLACK) {
                        w.left?.color = Color.BLACK
                        w.color = Color.RED
                        rightRotate(w)
                        w = node.parent?.right
                    }
                    w?.color = node?.parent?.color
                    node?.parent?.color = Color.BLACK
                    w?.right?.color = Color.BLACK
                    leftRotate(node?.parent!!)
                    node = root
                }
            } else {
                var w = node?.parent?.left
                if (w?.color == Color.RED) {
                    w.color = Color.BLACK
                    node.parent?.color = Color.RED
                    rightRotate(node.parent!!)
                    w = node.parent?.left
                }
                if (w?.right?.color == Color.BLACK && w.left?.color == Color.BLACK) {
                    w.color = Color.RED
                    node = node.parent
                } else {
                    if (w?.left?.color == Color.BLACK) {
                        w.right?.color = Color.BLACK
                        w.color = Color.RED
                        leftRotate(w)
                        w = node.parent?.left
                    }
                    w?.color = node?.parent?.color
                    node?.parent?.color = Color.BLACK
                    w?.left?.color = Color.BLACK
                    rightRotate(node?.parent!!)
                    node = root
                }
            }
        }
        node?.color = Color.BLACK
    }

}