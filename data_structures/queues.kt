// A queue is a linear data structure that follows a First In First Out order for its operations.
// The first element added to the queue will be the first element to be removed.

// Think of a ticket counter.
// The first person in the line is the first person to be served, and as people join the line, they wait at the end.
// Entering the queue is the "enqueue" operation.
// Being served and leaving the line is the "dequeue" operation.

class Queue<T> {
	private val elements: MutableList<T> = mutableListOf()

	// Entering the ticket line
	fun enqueue(item: T) {
		elements.add(item)
	}

	// Serve the ticket to the first person on the line
	fun dequeue(): T? {
		if (isEmpty()) {
			return null
		}
		return elements.removeAt(0)
	}

	fun peek(): T? {
		return elements.firstOrNull()
	}
}

fun main() {
	val queue = Queue<Int>()
	queue.enqueue(1)
	queue.enqueue(2)
	queue.enqueue(3)
	println("Front of the queue: ${queue.peek()}") // 1
	queue.dequeue() // Serve the first customer, numbered 1
	println("Front of the queue after dequeue: ${queue.peek()}") // 2
}
