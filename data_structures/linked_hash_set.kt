// LinkedHashSet Data Structure:

// Structure: LinkedHashSet is a collection that:
// - Maintains the insertion order of elements, providing predictable iteration order.
// - Ensures that no duplicate elements are stored.
// - Supports basic operations like insertion, deletion, and retrieval in constant time.

// Implementation:
// - Internally, LinkedHashSet uses a hash table for storage, providing O(1) time complexity for basic operations like add, remove, and contains.
// - Additionally, it maintains a linked list to preserve the insertion order of elements.

// Advantages:
// - Guarantees uniqueness of elements while preserving their insertion order.
// - Suitable for scenarios where both uniqueness and order of elements are required, such as maintaining a history of user actions or processing data in the order it was received.
