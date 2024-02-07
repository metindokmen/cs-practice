// An R-tree is a tree data structure optimized for indexing spatial information in multi-dimensional space.
// Each node in an R-tree represents a bounding box that encompasses a group of spatial objects.
// The root node represents the entire space, and as you traverse down the tree, the bounding boxes become more specific.
// Each leaf node contains references to actual spatial objects.

// Consider a mapping application where you want to efficiently find all restaurants within a certain area on the map.
// The application needs to handle queries like "find all restaurants within this bounding box."
// An R-tree can efficiently index the spatial data of restaurants' locations and quickly answer such queries.

class BoundingBox(
    val minX: Double,
    val minY: Double,
    val maxX: Double,
    val maxY: Double,
)

class RTreeNode<T>(
    val boundingBox: BoundingBox,
    val children: MutableList<RTreeNode<T>> = mutableListOf(),
    val data: MutableList<T> = mutableListOf()
)

class RTree<T> {
    private var root: RTreeNode<T>? = null

    fun insert(data: T, boundingBox: BoundingBox) {
        root = insert(root, data, boundingBox)
    }

    private fun insert(node: RTreeNode<T>?, data: T, boundingBox: BoundingBox): RTreeNode<T> {
        if (node == null) {
            return RTreeNode(boundingBox).apply { this.data.add(data) }
        }

        if (node.children.isEmpty()) {
            node.data.add(data)
            return node
        }

        // Find the child node with the minimum enlargement
        val bestChild = node.children.minByOrNull { enlargement(it.boundingBox, boundingBox) }!!

        // Recursively insert into the best child
        val newChild = insert(bestChild, data, boundingBox)

        // Update the bounding box of the parent node
        node.boundingBox.expand(newChild.boundingBox)

        return node
    }

}