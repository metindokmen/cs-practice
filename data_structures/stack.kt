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

    // @TODO: Add an element to the top of the stack
    fun push() {}

    // @TODO: Remove and return the top element of the stack
    fun pop() {}

    // @TODO: Return the top element without removing it
    fun peek() {}

    // @TODO: Return the number of elements in the stack
    fun size() {}

    // @TODO: Check if the stack is empty
    fun isEmpty() {}

    // @TODO: Display the stack elements
    fun display() {}
}