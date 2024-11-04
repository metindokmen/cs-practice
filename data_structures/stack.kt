// Stack is a linear data structure that follows a particular order in which the operations are performed.
// The order may be LIFO (Last In First Out) or FILO (First In Last Out).

// Operations:
// - Push: Adds an element to the top of the stack.
// - Pop: Removes and returns the element at the top of the stack.
// - Peek: Returns the element at the top of the stack without removing it.
// - Size: Returns the number of elements in the stack.
// - isEmpty: Checks if the stack is empty.

// Applications of Stack:
// - Function calls
// - Expression evaluation
// - Backtracking
// - Undo/redo operations


// Node class representing each element in the stack
data class Node<T>(val value: T, var next: Node<T>? = null)

// Stack class implementing basic stack operations
class Stack<T> {
    private var top: Node<T>? = null
    private var size: Int = 0

    // Add an element to the top of the stack
    fun push(value: T) {
        val newNode = Node(value, top)
        top = newNode
        size++
        println("Pushed: $value")
    }

    // Remove and return the top element of the stack
    fun pop(): T? {
        if (isEmpty()) {
            println("Stack is empty. Cannot pop.")
            return null
        }
        val poppedValue = top?.value
        top = top?.next
        size--
        println("Popped: $poppedValue")
        return poppedValue
    }

    // Return the top element without removing it
    fun peek(): T? {
        if (isEmpty()) {
            println("Stack is empty. Nothing to peek.")
            return null
        }
        println("Peek: ${top?.value}")
        return top?.value
    }

    // Return the number of elements in the stack
    fun size(): Int {
        println("Stack size: $size")
        return size
    }

    // Check if the stack is empty
    fun isEmpty(): Boolean {
        val empty = size == 0
        println("Is stack empty? $empty")
        return empty
    }

    // Display the stack elements
    fun display() {
        if (isEmpty()) {
            println("Stack is empty.")
            return
        }
        var current = top
        print("Stack (top to bottom): ")
        while (current != null) {
            print("${current.value}")
            current = current.next
        }
        println()
    }
}