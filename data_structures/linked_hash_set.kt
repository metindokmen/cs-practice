// LinkedHashSet Data Structure:

// 1. Structure: LinkedHashSet is a collection that:
// - Maintains the insertion order of elements, providing predictable iteration order.
// - Ensures that no duplicate elements are stored.
// - Supports basic operations like insertion, deletion, and retrieval in constant time.

// 2. Implementation:
// - Internally, LinkedHashSet uses a hash table for storage, providing O(1) time complexity for basic operations like add, remove, and contains.
// - Additionally, it maintains a linked list to preserve the insertion order of elements.

// 3. Advantages:
// - Guarantees uniqueness of elements while preserving their insertion order.
// - Suitable for scenarios where both uniqueness and order of elements are required, such as maintaining a history of user actions or processing data in the order it was received.

// Imagine organizing a guest list for a party where you want to ensure uniqueness while preserving the order in which guests RSVP.
// A LinkedHashSet can be used to store the guest list, ensuring that each guest is unique and maintaining the order in which they responded.

fun main() {
    // Creating a LinkedHashSet of integers
    val linkedHashSet = LinkedHashSet<Int>()

    // Inserting elements into the LinkedHashSet
    linkedHashSet.add(10)
    linkedHashSet.add(20)
    linkedHashSet.add(30)

    // Adding a duplicate element
    linkedHashSet.add(20)

    // Removing an element
    linkedHashSet.remove(20)

    // Displaying the elements in the LinkedHashSet
    println("LinkedHashSet elements:")
    linkedHashSet.forEach { println(it) }
}
