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

    private fun enlargement(box1: BoundingBox, box2: BoundingBox): Double {
        val minX = minOf(box1.minX, box2.minX)
        val minY = minOf(box1.minY, box2.minY)
        val maxX = maxOf(box1.maxX, box2.maxX)
        val maxY = maxOf(box1.maxY, box2.maxY)
        val oldArea = (box1.maxX - box1.minX) * (box1.maxY - box1.minY)
        val newArea = (maxX - minX) * (maxY - minY)
        return newArea - oldArea
    }

    fun search(query: BoundingBox): List<T> {
        val result = mutableListOf<T>()
        search(root, query, result)
        return result
    }

    private fun search(node: RTreeNode<T>?, query: BoundingBox, result: MutableList<T>) {
        if (node == null) return
        if (!node.boundingBox.intersects(query)) return

        if (node.children.isEmpty()) {
            result.addAll(node.data)
        } else {
            node.children.forEach { search(it, query, result) }
        }
    }
}

fun main() {
    val rTree = RTree<String>()

    rTree.insert("Restaurant A", BoundingBox(0.0, 0.0, 1.0, 1.0))
    rTree.insert("Restaurant B", BoundingBox(2.0, 2.0, 3.0, 3.0))
    rTree.insert("Restaurant C", BoundingBox(-1.0, -1.0, 0.5, 0.5))

    val queryBox = BoundingBox(0.0, 0.0, 2.0, 2.0)
    val result = rTree.search(queryBox)

    println("Restaurants within the query box:")
    result.forEach { println(it) }
}
