// A Skip List is a data structure for storing a sorted collection of items with a hierarchy of linked lists that skip over varying numbers of elements.
// It allows for fast search, insertion, and deletion operations.
// Skip Lists are an alternative to balanced trees and are easier to implement while providing similar efficiency.

// Think of an express train service between cities. There are local trains that stop at every city, and then there are express trains that skip many cities and only stop at major hubs.
// If you're travelling a long distance, you might take an express train and then switch to a local train at the last hub.
// This is how a Skip List works. The "express" linked lists allow us to skip over many elements, and the "local" linked lists provide fine-grained traversal.

class SkipListNode<T: Comperable<T>>(val value: T) {
    val nextNodes: MutableList<SkipListNode<T>?> = mutableListOf()

    fun level(): Int = nextNodes.size
}

class SkipList<T: Comparable<T>>(private val maxLevel: Int) {
    private val head = SkipListNode<T?>(null)
    private val random = java.util.Random()

    init {
        for (i in 0 until maxLevel) {
            head.nextNodes.add(null)
        }
    }

    fun find(value: T): SkipListNode<T>? {
        val current = head
        for (i in maxLevel - 1 downTo 0) {
            while (current.nextNodes[i] != null && current.nextNodes[i]!!.value < value) {
                current = current.nextNodes[i]!!
            }
        }
        return current.nextNodes[0]?.takeIf { it.value == value }
    }

    fun insert(value: T) {
        val newNode = SkipListNode(value)
        val current = head
        var level = 0
        while (level < maxLevel && random.nextBoolean()) {
            level++
        }
        for (i in maxLevel - 1 downTo 0) {
            while (current.nextNodes[i] != null && current.nextNodes[i]!!.value < value) {
                current = current.nextNodes[i]!!
            }
            if (i < newNode.nextNodes.size) {
                newNode.nextNodes[i] = current.nextNodes[i]
                current.nextNodes[i] = newNode
            }
        }
    }

    fun delete(value: T) {
        var current = head
        for (i in maxLevel - 1 downTo 0) {
            while (current.nextNodes[i] != null && current.nextNodes[i]!!.value < value) {
                current = current.nextNodes[i]!!
            }
            if (current.nextNodes[i]?.value == value) {
                current.nextNodes[i] = current.nextNodes[i]!!.nextNodes[i]
            }
        }
    }
}