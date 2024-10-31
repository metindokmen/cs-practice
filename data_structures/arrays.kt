// Array is a linear data structure that stores a collection of elements of the same data type.
// Elements are allocated contiguous memory, allowing for constant-time access.
// Each element has a unique index number.

// Operations on Array:
// - Traversal: Iterating through the elements of an array.
// - Insertion: Adding an element to the array at a specific index.
// - Deletion: Removing an element from the array at a specific index.
// - Searching: Finding an element in the array by its value or index.

// Types of Arrays:
// - One-dimensional Array: A simple array with a single dimension.
// - Multidimensional Array: An array with multiple dimensions, such as a matrix.

// Applications of Array:
// - Storing data in a sequential manner.
// - Implementing queues, stacks and other data structures
// - Representing matrices and tables

fun main() {
    // Declare and initialize a one-dimensional array
    val oneDArray = arrayOf(10, 20, 30, 40, 50)
    println("One-dimensional Array: ${oneDArray.joinToString(", ")}")

    // Traversal (iterating through elements)
    println("Traversal of One-dimensional Array:")
    for (element in oneDArray) {
        print("$element")
    }
    println()

    // Insertion
    // In Kotlin, arrays are fixed-size, so we create a new array for insertion
    val insertedArray = oneDArray.toMutableList() // Convert to mutable list
    insertedArray.add(60) // Add new element
    println("After insertion: ${insertedArray.joinToString(", ")}")

    // Deletion
    // Since arrays are fixed-size, we convert to a mutable list again
    insertedArray.removeAt(2) // Remove element at index 2
    println("After deletion: ${insertedArray.joinToString(", ")}")

    // @TODO: Searching
}