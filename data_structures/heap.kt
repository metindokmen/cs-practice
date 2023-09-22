// A heap is a specialized tree-based data structure that satisfies the heap property.

// There are two types of heap:
// 1. Max-Heap: For any given node I, the value of I is greater than or equal to the values of its children.
// 2. Min-Heap: For any given node i, the value of I is less than or equal to the values of its children.

// Think of a priority queue system in a hospital. Patients are assigned priority numbers, and the one with the highest priority (like critical condition) is treated first.
// This system can be implemented using a max-heap where the patient with the maximum priority is always at the top.

class MaxHeap(private val size: Int) {
    private val items = IntArray(size)
    private var count = 0

    // Get index of the left child, right child, and parent of the current node
    private fun getLeftChildIndex(parentIndex: Int) = 2 * parentIndex + 1
    private fun getRightChildIndex(parentIndex: Int) = 2 * parentIndex + 2
    private fun getParentIndex(childIndex: Int) = (childIndex - 1) / 2

    // Check if the current node has a left child, right child, or parent
    private fun hasLeftChild(index: Int) = getLeftChildIndex(index) < count
    private fun hasRightChild(index: Int) = getRightChildIndex(index) < count
    private fun hasParent(index: Int) = getParentIndex(index) >= 0

    // Retrieve the left child, right child, or parent of the current node
    private fun leftChild(index: Int) = items[getLeftChildIndex(index)]
    private fun rightChild(index: Int) = items[getRightChildIndex(index)]
    private fun parent(index: Int) = items[getParentIndex(index)]

    // Get the maximum element without removing it
    fun peek(): Int {
        if (count == 0) throw IllegalStateException()
        return items[0]
    }

    // Remove and return the maximum element
    fun pool(): Int {
        if (count == 0) throw IllegalStateException()
        val item = items[0]
        items[0] = items[count - 1]
        count--
        heapifyDown()
        return item
    }

    // Ad an element to the heap
    fun add(item: Int) {
        items[count] = item
        count++
        heapifyUp()
    }

    // Move the newly added element up to its correct position to maintain the heap property
    private fun heapifyUp() {
        var index = count - 1
        while (hasParent(index) && parent(index) < items[index]) {
            swap(getParentIndex(index), index)
            index = getParentIndex(index)
        }
    }

    // Move the root element down to its correct position after removal of the maximum element
    private fun heapifyDown() {
        var index = 0
        while (hasLeftChild(index)) {
            var largerChildIndex = getLeftChildIndex(index)
            if (hasRightChild(index) && rightChild(index) > leftChild(index)) {
                largerChildIndex = getRightChildIndex(index)
            }
            if (items[index] > items[largerChildIndex]) {
                break
            } else {
                swap(index, largerChildIndex)
            }
            index = largerChildIndex
        }
    }

    // Utility function to swap two elements in the array
    private fun swap(indexOne: Int, indexTwo: Int) {
        val temp = items[indexOne]
        items[indexOne] = items[indexTwo]
        items[indexTwo] = temp
    }
}

fun main() {
    val maxHeap = MaxHeap(10)
    maxHeap.add(5)
    maxHeap.add(3)
    maxHeap.add(8)
    println(maxHeap.peek()) // Output: 8
    println(maxHeap.poll()) // Output: 8
    println(maxHeap.peek()) // Output: 5
}