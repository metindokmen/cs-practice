// Queue is a fundamental data structure used for storing and managing data in a specific order.
// It follows the principle of FIFO (First In, First Out), where the first element added to the queue is the first one to be removed.

// Operations
// - Enqueue: Adds an element to the rear of the queue.
// - Dequeue: Removes an element from the front of the queue.
// - Peek: Retrieves the front element without removing it.
// - isEmpty: Checks if the queue is empty
// - isFull: Checks if the queue is full

// Types of Queue:
// - Circular Queue: Last element connects to the first element.
// - Double-Ended Queue (Deque): Operations can be performed from both ends.
// - Priority Queue: Elements are arranged based on priority.

// Applications of Queue
// - Job scheduling
// - Message queing
// - Simulation modeling
// - Data buffering

class Queue<T>(private val capacity: Int) {
    private val elements: Array<Any?> = arrayOfNulls<Any?>(capacity)
    private var front = 0
    private var rear = -1
    private var size = 0

    // Enqueue: Adds an element to the rear of the queue
    fun enqueue(value: T): Boolean {
        if (isFull()) {
            println("Queue is full. Cannot enqueue $value.")
            return false
        }
        rear = (rear + 1) % capacity
        elements[rear] = value
        size++
        println("Enqueued: $value")
        return true
    }

    // Dequeue: Removes an returns the element at the front of the queue
    fun dequeue(): T? {
        if (isEmpty()) {
            println("Queue is empty. Cannot dequeue.")
            return null
        }
        val dequeuedValue = elements[front] as T
        elements[front] = null
        front = (front + 1) % capacity
        size--
        println("Dequeued: $dequeuedValue")
        return dequeuedValue
    }

    // Peek: Retrieves the front element without removing it
    fun peek(): T? {
        if (isEmpty()) {
            println("Queue is empty. Nothing to peek.")
            return null
        }
        println("Peek: ${elements[front]}")
        return elements[front] as T
    }

    fun isEmpty(): Boolean {
        return size == 0
    }

    fun isFull(): Boolean {
        return size == capacity
    }

    fun display() {
        if (isEmpty()) {
            println("Queue is empty.")
            return
        }
        print("Queue (front to rear): ")
        var index = front
        repeat(size) {
            print("${elements[index]}")
            index = (index + 1) % capacity
        }
        println()
    }
}
