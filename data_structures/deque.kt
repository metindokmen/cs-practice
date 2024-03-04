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

// Consider a line at a theme park where visitors enter from one end and exit from the other.
// A deque can represent this scenario where visitors can join the line (enqueue) from either end and exit (dequeue) from either end, allowing for efficient management of the queue.

import java.util.ArrayDeque

fun main() {
    // Creating a deque of strings
    val deque = ArrayDeque<String>()

    // Inserting elements into the deque from the front and the back
    deque.addFirst("First")
    deque.addLast("Last")
    deque.addFirst("New First")

    // Retrieving and removing elements from the front and the back
    val removedFirst = deque.removeFirst()
    val removedLast = deque.removeLast()

    // Peeking at the elements from the front and the back
    val peekFirst = deque.peekFirst()
    val peekLast = deque.peekLast()

    println("Removed First: $removedFirst")
    println("Removed Last: $removedLast")
    println("Peek First: $peekFirst")
    println("Peek Last: $peekLast")
}
