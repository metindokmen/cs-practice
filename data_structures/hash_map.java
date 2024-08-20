// HashMap is a data structure in computer science that provides a fast and efficient way to store and retrieve data.
// It's part of the Java Collections Framework and is typically used when you want to associate keys with values,
// allowing quick lookup, insertion, and deletion of key-value pairs.

// Basic Terminology:
// 1. Key: An identifier used to access a particular value in the HashMap. Think of it like a unique label.
// 2. Value: The data associated with a key. It's the actual information you want to retrieve or store.
// 3. Hash Function: A function that takes a key and computes an index (hash code) where the associated value is stored in the underlying array.
// 4. Bucket: The location in the underlying array where the key-value pair is stored. Multiple keys can map to the same bucket,
// which is managed through a technique called chaining or open addressing.

// How HashMaps Work:
// 1. Inserting a Key-Value Pair:
// - When you insert a key-value pair into a HashMap, the key is passed through a hash function to determine its hash code (an index in an internal array).
// - The value is then stored at that index in the array.
// - If another key generates the same hash code (a collision), the HashMap resolves it by chaining the new key-value pair to the existing pair using a linked list or some other structure.
