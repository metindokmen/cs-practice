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

    // Insert (Put) operation with Separate Chaining for collision resolution
    fun put(key: K, value: V) {
        val hashValue = hash(key)
        val bucket = table[hashValue]

        // Update value if key already exists
        for (i in bucket.indices) {
            if (bucket[i].first == key) {
                bucket[i] = Pair(key, value)
                return
            }
        }

        // Add new key-value pair if no match found
        bucket.add(Pair(key, value))
    }

    // Retrieve (Get) operation
    fun get(key: K): V? {
        val hashValue = hash(key)
        val bucket = table[hashValue]
        for (pair in bucket) {
            if (pair.first == key) return pair.second
        }
        return null
    }

    // Remove operation
    fun remove(key: K): Boolean {
        val hashValue = hash(key)
        val bucket = table[hashValue]
        val iterator = bucket.iterator()

        while (iterator.hasNext()) {
            if (iterator.next().first == key) {
                iterator.remove()
                return true
            }
        }
        return false
    }

    // Display hash table
    fun display() {
        for (i in table.indices) {
            print("Bucket $i: ")
            for (pair in table[i]) {
                print("(${pair.first} -> ${pair.second})")
            }
            println()
        }
    }
}

fun main() {
    val hashTable = HashTable<String, Int>(5)

    hashTable.put("Alice", 25)
    hashTable.put("Bob", 30)
    hashTable.put("Charlie", 35)
    hashTable.put("Dave", 40)

    println("Retrieve 'Alice': ${hashTable.get("Alice")}") // Retrieve 'Alice': 25
    println("Retrieve 'Bob': ${hashTable.get("Bob")}") // Retrieve 'Bob': 30

    hashTable.remove("Charlie")
    hashTable.display()

    // Bucket 0: (Alice -> 25)
    // Bucket 1: (Dave -> 40)
    // Bucket 2: (Bob -> 30)
    // Bucket 3:
    // Bucket 4:
}


// Example 2: Custom Hash Table with Open Addressing (Linear Probing)
class LinearProbingHashTable<K, V>(private val capacity: Int) {
    private val keys = arrayOfNulls<Any?>(capacity)
    private val values = arrayOfNulls<Any?>(capacity)

    // Hash function using Division Method
    private fun hash(key: K): Int = key.hashCode() % capacity

    // Insert (Put) operation with Linear Probing
    fun put(key: K, value: V) {
        var index = hash(key)
        while (keys[index] != null && keys[index] != key) {
            index = (index + 1) % capacity // Linear probing
        }
        keys[index] = key
        values[index] = value
    }

    // Retrieve (Get) operation
    fun get(key: K): V? {
        var index = hash(key)
        while (keys[index] != null) {
            if (key[index] == key) {
                return values[index] as V
            }
            index = (index + 1) % capacity
        }
        return null
    }

    // Remove operation
    fun remove(key: K) {
        var index = hash(key)
        while (keys[index] != null) {
            if (keys[index] == key) {
                keys[index] = null
                values[index] = null
                return
            }
            index = (index + 1) % capacity
        }
    }

    // Display hash table
    fun display() {
        for (i in keys.indices) {
            if (keys[i] != null) {
                println("Key: ${keys[i]}, Value: ${values[i]}")
            }
        }
    }
}

fun main() {
    val hashTable = LinearProbingHashTable<String, Int>(7)

    hashTable.put("Alice", 25)
    hashTable.put("Bob", 30)
    hashTable.put("Charlie", 35)

    println("Retrieve 'Alice': ${hashTable.get("Alice")}")
    println("Retrieve 'Bob': ${hashTable.get("Bob")}")

    hashTable.remove("Charlie")
    hashTable.display()
}
