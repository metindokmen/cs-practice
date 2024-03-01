// Priority Queue data structure is a queue where elements are ordered based on their priority.

// 1. Structure: Priority Queue is an abstract data type that supports the following operations:
// - Insertion: Adding an element with an associated priority.
// - Deletion: Removing and returning the element with the highest priority.
// - Peek: Retrieving the element with the highest priority without removing it.

// 2. Implementation:
// - Priority Queue can be implemented using various underlying data structures such as binary heaps, binary search trees, or arrays.
// - Binary heaps are commonly used due to their efficient insertion, deletion, and peek operations, with time complexities of O(log n), where n is the number of elements in the queue.

// 3. Advantages:
// - Provides efficient access to the element with the highest priority.
// - Suitable for scenarios where elements need to be processed in a specific order based on their priority.
// - Can be used in algorithms like Dijkstra's shortest path algorithm and Huffman coding.

import java.util.PriorityQueue

fun main() {
    // Create a priority queue of integers
    val pq = PriorityQueue<Int>()

    // Insert elements into the priority queue
    pq.offer(30)
    pq.offer(20)
    pq.offer(50)
    pq.offer(10)

    // Retrieve and remove the element with the highest priority
    val highestPriorityElement = pq.poll()
    println("Element with the highest priority: $highestPriorityElement")

    // Peek at the element with the highest priority
    val peekedElement = pq.peek()
    println("Element iwht the highest priority after peek: $peekedElement")
}
