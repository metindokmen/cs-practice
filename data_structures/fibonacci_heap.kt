// A Fibonacci Heap is a collection of rooted trees that satisfy the min-heap property.
// Each tree in the heap is a minimum heap, meaning the key of a parent node is less than or equal to the keys of its children.
// Additionally, it maintains a pointer to the minimum node in the heap.

// Operations:
// Insertion: New nodes are inserted into the heap in constant time by creating a new tree containing the node and merging it with the existing heap.
// Union: Two Fibonacci Heaps can be merged efficiently by simply linking the roots of their trees.
// Extract-Min: Removing the minimum node from the heap requires consolidating trees and updating the minimum pointer.
// Decrease-Key: Decreasing the key of a node involves cutting the node from its parent and potentially cascading cuts up the tree to maintain the heap property.
// Delete: Deleting a node from the heap involves decreasing its key to negative infinity (effectively removing it from the heap) and then performing extract-min.

// Amortized Time Complexity:
// Insertion: O(1)
// Union: O(1)
// Extract-Min: O(log n)
// Decrease-Key: O(1)
// Delete: O(log n)

// Consider you have a system where tasks have different priorities, and you need to efficiently manage them.
// The Fibonacci Heap can be used to implement a priority queue efficiently, allowing for quick insertion, deletion, and modification of tasks with different priorities.

data class FibonacciNode<T>(var key: Int, val value: T, var parent: FibonacciNode<T>? = null, var child: FibonacciNode<T>? = null, var left: FibonacciNode<T>? = null, var right: FibonacciNode<T>? = null, var degree: Int = 0, var marked: Boolean = false)

class FibonacciHeap<T> {
    private var minNode: FibonacciNode<T>? = null

    fun insert(key: Int, value: T) {
        val newNode = FibonacciNode(key, value)
        minNode = if (minNode == null) newNode else mergeList(minNode!!, newNode)
        if (newNode.key < minNode!!.key) {
            minNode = newNode
        }
    }
}
