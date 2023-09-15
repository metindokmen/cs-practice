// A stack is a linear data structure that follows a Last In First Out order for its operations.
// The last element added to the stack will be the first element to be removed.

// Think of a stack of plates in a cafeteria.
// When you pick a plate, you take the one from the top.
// When you return it, you place it back on the top.
// The plate on the top is the last plate to be added to the stack, but the first to be removed.

class Stack<T> {
	private val elements: MutableList<T> = mutableListOf()

	// Add a plate onto the stack of plates
	fun push(item: T) {
		elements.add(item)
	}

	// Pop the top plate from the stack
	fun pop(): T? {
		if (isEmpty()) {
			return null
		}
		return elements.removeAt(elements.size - 1)
	}

	// Look at the top element without popping it.
	fun peek(): T? {
		return elements.lastOrNull()
	}

	fun printStack() {
		for (item in elements.reversed()) {
			println(item)
		}
	}
}

fun main() {
	val stack = Stack<Int>()
	stack.push(1)
	stack.push(2)
	stack.push(3)
	println("Top of the stack: ${stack.peek()}")
	stack.pop()
	println("Top of the stack after pop: ${stack.peek()}")
	stack.printStack()
}