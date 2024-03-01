// LinkedHashMap combines the features of a linked list and a hash map to provide ordered key-value storage with fast access.

// 1. Structure:
// LinkedHashMap is a combination of a hash table and a doubly linked list.
// It maintains a predictable iteration order that is the order in which key-value pairs were inserted into the map.
// 2. Operations:
// Insertion and Retrieval: LinkedHashMap allows inserting key-value pairs and retrieving values associated with keys.
// It preserves the insertion order, making it suitable for scenarios where maintaining the order of elements is important.
// Deletion: Similar to other hash map implementations, LinkedHashMap supports the deletion of key-value pairs.
// Iteration: It provides methods to iterate over the key-value pairs in the order of insertion, enabling easy traversal of elements.
// 3. Advantages:
// - Preserves the insertion order of elements, making it useful for scenarios where iteration order matters.
// - Provides fast access to elements based on keys with average O(1) time complexity for insertion, deletion, and retrieval operations.
// - Suitable for implementing caching strategies, maintaining a history of operations, and managing ordered collections of data.
