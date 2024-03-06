// Deque Data Structure

// 1. Structure: Deque is a linear data structure that supports the following operations:
// Insertion and Deletion: Elements can be added or removed from both the front and the back.
// Peek: Retrieving the element at the front or the back without removing it.
// Size: Getting the number of elements in the deque.

// 2. Implementation:
// Deque can be implemented using various underlying data structures such as arrays, linked lists, or doubly linked lists.
// Doubly linked lists are commonly used as they provide efficient insertion and deletion operations at both ends with O(1) time complexity.

// 3. Advantages:
// Provides flexibility in adding and removing elements from both ends, making it suitable for scenarios where elements need to be accessed from either direction.
// Can be used in algorithms like breadth-first search (BFS) and maintaining sliding windows in algorithms like finding maximum subarrays.

// Consider a printer job queue where new print jobs need to be added at the end of the queue while urgent print jobs may need to be inserted at the front.
// A deque can efficiently handle both scenarios, allowing for efficient insertion and removal at both ends.

import java.util.ArrayDeque

fun main() {
    // Create a Deque of integers
    val deque = ArrayDeque<Int>()

    // Add elements to the front and back of the deque
    deque.offerFirst(10)
    deque.offerLast(20)
    deque.offerLast(30)
    deque.offerFirst(5)

    // Remove elements from the front and back of the deque
    val removedFirst = deque.pollFirst()
    val removedLast = deque.pollLast()

    // Display the remaining elements in the deque
    deque.forEach { println(it) }
}
