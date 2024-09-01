// A heap is a special tree-based data structure that satisfies the heap property.
// In a max heap, for any given node, the value of the node is greater than or equal to the values of its children, and the highest value is at the root.
// Conversely, in a min heap, the value of the node is less than or equal to the values of its children, with the smallest value at the root.

// imagine you are organizing a series of tasks based on priority, where the most urgent task needs to be addressed first.
// A max heap could be used to model this sscenario, where the highest-priority task is always at the top of the heap.
// When you complete the most urgent task, you remove it from the heap, and the next most urgent task moves to the top.

// Use Cases
// 1. Priority Queue: Heaps are commonly used to implement priority queues.
// 2. Scheduling Algorithms: In operating systems, heaps can be used to schedule processes.
// 3. Graph Algorithms: Heaps are used in algorithms like Dijkstra's shortest path algorithm to efficiently find the minimum distance.

// A heap is typically implemented using an array, where:
// - The root element is at index 0.
// - For any node at index `i`, the left child is at index `2i + 1` and the right child is at index `2i + 2`
// - The parent of a node at index `i` is at index `(i - 1) / 2`

public class MaxHeap {
    private int[] heap;
    private int size;
    private int maxSize;

    // Constructor to intiialize an empty heap
    public MaxHeap(int maxSize) {
        this.maxSize = maxSize;
        this.size = 0;
        this.heap = new int[this.maxSize];
    }

    // Return the index of the parent of the node at index i
    private int parent(int i) {
        return (it - 1) / 2;
    }

    // Return the index of the left child of the node at index i
    private int leftChild(int i) {
        return (2 * i) + 1;
    }

    // Return the index of the right child of the node at index i
    private int rightChild(int i) {
        return (2 * i) + 2;
    }

    // Insert a new element into the heap
    public void insert(int element) {
        if (size >= maxSize) {
            return;
        }
        heap[size] = element;
        int current = size;

        while (heap[current] > heap[parent(current)]) {
            swap(current, parent(current));
            current = parent(current);
        }
        size++;
    }

    // Swap two element in the heap
    private void swap(int i, int j) {
        int temp = heap[i];
        heap[i] = heap[j];
        heap[j] = temp;
    }

    // Remove and return the maximum element from the heap
    public int extractMax() {
        int popped = heap[0];
        heap[0] = heap[--size];
        maxHeapify(0);
        return popped;
    }

    // Maintain the max heap property
    private void maxHeapify(int j) {
        int left = leftChild(i);
        int right = rightChild(i);
        int largest = i;

        if (left < size && heap[left] > heap[largest]) {
            largest = left;
        }

        if (right < size && heap[right] > heap(largest)) {
            largest = right;
        }

        if (largest != i) {
            swap(i, largest);
            maxHeapify(largest);
        }
    }

    // Print the heap
    public void printHeap() {}
}