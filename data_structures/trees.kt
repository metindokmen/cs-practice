// A tree is a hierarchical data structure that consists of nodes connected by edges.
// Unlike arrays, linked lists, stacks and queues (which are linear data structures), trees are hierarchical.

// The topmost node is called the root.
// The elements that branch from the root are called nodes.

// Key Terminology:
// 1. Root: The topmost node in a tree.
// 2. Child: A node that directly connected to another node when moving away from the root.
// 3. Parent: The converse of a child.
// 4. Leaf: A node with no children.
// 5. Sibling: Nodes with the same parent.
// 6. Depth of a Node: The number of edges from the root to the node.
// 7. Height of a Node: The number of edges in the longest path from the root to a leaf.


// Think of an organization. The CEO sits at the top (root).
// Below him are vice presidents (children of the CEO/root).
// Each VP oversees several managers (children of VP's).
// The structure keeps breaking down until we get to the least experienced employees - maybe interns (leaves).

class TreeNode<T>(val value: T) {
    val children: MutableList<TreeNode<T>> = mutableListOf()

    fun addChild(node: TreeNode<T>) {
        children.add(node)
    }
}

fun main() {
    val CEO = TreeNode("CEO")

    val VP1 = TreeNode("VP of Engineering")
    val VP2 = TreeNode("VP of Marketing")

    CEO.addChild(VP1)
    CEO.addChild(VP2)

    val engineer = TreeNode("Engineer 1")
    VP1.addChild(engineer)

    val manager1 = TreeNode("Manager 1 - Marketing")
    val manager2 = TreeNode("Manager 2 - Marketing")

    VP2.addChild(manager1)
    VP2.addChild(manager2)

    println(CEO.value) // Prints "CEO" to the stdout
    println(CEO.children[0].value) // Prints "VP of Engineering"
    println(CEO.children[1].children[0].value) // Prints "Manager 1 - Marketing"
}
