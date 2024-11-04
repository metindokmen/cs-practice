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


// Using ArrayDeque
class QueueUsingArrayDeque<T> {
    private val queue = ArrayDeque<T>()

    // Enqueue: Adds an element to the rear of the queue
    fun enqueue(value: T) {
        queue.addLast(value)
        println("Enqueued: $value")
    }

    // Dequeue: Removes and returns the element at the front of the queue
    fun dequeue(): T? {
        if (isEmpty()) {
            println("Queue is empty. Cannot dequeue.")
            return null
        }
        val dequeuedValue = queue.removeFirst()
        println("Dequeued: $dequeuedValue")
        return dequeuedValue
    }

    // Peek: Retrieves the front element without removing it
    fun peek(): T? {
        if (isEmpty()) {
            println("Queue is empty. Nothing to peek.")
            return null
        }
        val frontValue = queue.first()
        println("Peek: $frontValue")
        return frontValue
    }

    // isEmpty: Checks if the queue is empty
    fun isEmpty(): Boolean {
        val empty = queue.isEmpty()
        println("Is queue empty? $empty")
        return empty
    }

    // Display the queue elements
    fun display() {
        if (isEmpty()) {
            println("Queue is empty.")
            return
        }
        println("Queue (front to rear): ${queue.joinToString(" ")})
    }
}

// Queues are useful for managing job scheduling tasks
fun jobScheduler(jobs: List<String>) {
    val jobQueue = QueueUsingArrayDeque<String>()
    jobs.forEach { jobQueue.enqueue(it) }

    while (!jobQueue.isEmpty()) {
        val currentJob = jobQueue.dequeue()
        println("Processing job: $currentJob")
    }
}

fun main() {
    val queue = Queue<Int>(5)

    queue.enqueue(10) // Enqueued: 10
    queue.enqueue(20) // Enqueued: 20
    queue.enqueue(30) // Enqueued: 30

    queue.display() // Queue (front to rear): 10 20 30

    queue.peek() // Peek: 10

    queue.dequeue() // Dequeued: 10
    queue.dequeue() // Dequeued: 20

    queue.display() // Queue (front to rear): 30

    println("Is queue empty? ${queue.isEmpty()}") // Is queue empty? false
    println("Is queue fulll? ${queue.isFull()}") // Is queue full? false

    val jobs = listOf("Job1", "Job2", "Job3")
    jobScheduler(jobs)

    // Enqueued: Job1
    // Enqueued: Job2
    // Enqueued: Job3
    // Dequeued: Job1
    // Processing job: Job1
    // Dequeued: Job2
    // Processing job: Job2
    // Dequeued: Job3
    // Processing job: Job3

}
