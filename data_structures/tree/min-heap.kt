// A Min-Heap is a specialized binary tree where each node's value is less than or equal to the values of its children.

class MinHeap {
    private val heap = mutableListOf<Int>()

    // Insert a new element into the Min-Heap
    fun insert(value: Int) {
        heap.add(value)
        heapifyUp(heap.size - 1)
    }

    // Remove and return the minimum element (root) from the Min-Heap
    fun removeMin(): Int? {
        if (heap.isEmpty()) return null
        if (heap.size == 1) return heap.removeAt(0)

        val min = heap[0]
        heap[0] = heap.removeAt(heap.size - 1)
        heapifyDown(0)
        return min
    }

    // Helper to maintain heap order after insertion
    private fun heapifyUp(index: Int) {
        var current = index
        while (current > 0) {
            val parent = (current - 1) / 2
            if (heap[current] >= heap[parent]) break
            heap.swap(current, parent)
            current = parent
        }
    }

    // Helper to maintain heap order after removal
    private fun heapifyDown(index: Int) {
        var current = index
        val size = heap.size

        while (true) {
            val left = 2 * current + 1
            val right = 2 * current + 2
            var smallest = current

            if (left < size && heap[left] < heap[smallest]) smallest = left
            if (right < size && heap[right] < heap[smallest]) smallest = right

            if (smallest == current) break
            heap.swap(current, smallest)
            current = smallest
        }
    }

    fun printHeap() {
        println(heap)
    }

    // Extension function to swap two elements in a MutableList
    private fun MutableList<Int>.swap(i: Int, j: Int) {
        val temp = this[i]
        this[i] = this[j]
        this[j] = temp
    }
}
