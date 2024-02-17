// A Fibonacci Heap is a collection of rooted trees that satisfy the min-heap property.
// Each tree in the heap is a minimum heap, meaning the key of a parent node is less than or equal to the keys of its children.
// Additionally, it maintains a pointer to the minimum node in the heap.

// Operations:
// Insertion: New nodes are inserted into the heap in constant time by creating a new tree containing the node and merging it with the existing heap.
// Union: Two Fibonacci Heaps can be merged efficiently by simply linking the roots of their trees.
// Extract-Min: Removing the minimum node from the heap requires consolidating trees and updating the minimum pointer.
// Decrease-Key: Decreasing the key of a node involves cutting the node from its parent and potentially cascading cuts up the tree to maintain the heap property.
// Delete: Deleting a node from the heap involves decreasing its key to negative infinity (effectively removing it from the heap) and then performing extract-min.
