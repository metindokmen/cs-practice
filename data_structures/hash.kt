// Hashing is a technique that generates a fixed-size output (hash value) from an input of variable size using mathematical formulas called hash functions.
// Hashing is used to determine an index or location for storing an item in a data structure, allowing for efficient retrieval and insertion.

// Key Concepts:
// - Hash Function: A mathematical function that maps an input to a hash value.
// - Hash Table: A data structure that stores key-value pairs, where the key is a hash value and the value is the actual data.
// - Collision: When two different keys produce the same hash value.

// Types of Hash Functions:
// - Division Method: Divides the input by a constant and uses the remainder as the hash value.
// - Mid Square Method: Squares the input and takes the middle digits as the hash value.
// - Folding Method: Divides the input into equal-sized blocks and adds them together to get the hash value.
// - Multiplication Method: Multiplies the input by a constant and takes the fractional part as the hash value.

// Collision Resolution Techniques:
// - Separate Chaining (Open Hashing): Stores colliding elements in a linked list at the corresponding hash value.
// - Open Addressing (Closed Hashing): Uses various strategies to find an alternative location for colliding elements within the hash table.

// Applications of Hashing:
// - Efficiently storing and retrieving data in databases and file systems.
// - Verifying passwords and digital signatures.
// - Distributing requests across multiple servers.
// - Generating secure hashes for data integrity and authentication.


// Custom Hash Table with Division Method and Separate Chaining
class HashTable<K, V>(private val capacity: Int) {
    private val table: Array<MutableList<Pair<K, V>>> = Array(capacity) { mutableListOf() }

    // Hash function using Division Method
    private fun hash(key: K): Int = key.hashCode() % capacity

}