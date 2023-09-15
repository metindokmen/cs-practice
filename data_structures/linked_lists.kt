// A linked list is a linear data structure where elements are stored in nodes.
// Each node has a value and a reference (link) to the next node in the sequence.

// Think of a treasure hunt. At each location (clue), you find a note that directs you to the next location.

// Each location represents a node in the linked list.
// The information on where to go (the next clue) is the reference or the link to the next node.
// Starting point is the head of the linked list, and the final clue, which doesn't lead anywhere, represents the tail.

class Node<T>(var value: T) {
	var next: Node<T>? = null
}

class LinkedList<T> {
	// When the LinkedList is first initialized, it will have no head or tail, therefore the default value for the head is null.
	private var head: Node<T>? = null

	fun append(value: T) {
		if (head == null) {
			// If head is null, it means this is the first element that will be added to the LinkedList.
			head = Node(value)
			return
		}

		// We initialize a variable called current to represent the current node, and set it to the head to start iterating.
		var current = head
		while (current?.next != null) {
			// As long as the current node's next value is not null, meaning there's a reference/link to the next clue in the treasure hunt, we set the current to that next node.
			current = current.next
		}
		current?.next = Node(value)
	}

	fun printList() {
		var current = head
		while (current != null) {
			print("${current.value} -> ")
			current = current.next
		}
		println("null")
	}
}

fun main() {
	val linkedList = LinkedList<Int>()
	linkedList.append(1)
	linkedList.append(2)
	linkedList.append(3)
	linkedList.printList() // Output: 1 -> 2 -> 3 -> null
}