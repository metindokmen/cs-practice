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

// 2. Retrieving a Value:
// - To retrieve a value, you provide the key.
// - The HashMap passess this key through the hash function, calculates the index, and retrieves the value stored at that index.

// 3. Handling Collisions:
// - Collisions occur when two different keys produce the same hash code.
// - Common strategies to resolve collisions include:
//  - Chaining: Store the collided pairs in a linked list or another data structure at the same array index.
//  - Open Addressing: Find the next available spot in the array.

import java.util.HashMap;

public class HashMap {
    // Create a HashMap to store students' grades
    HashMap<String, Integer> studentGrades = new HashMap<>();

    // Inserting key-value pairs into the HashMap
    studentGrades.put("Alice", 85);
    studentGrades.put("Bob", 92);
    studentGrades.put("Charlie", 78);

    // Retrieving values by key
    System.out.println("Akice's grade: " + studentGrades.get("Alice")); // Output: 85

    // Checking if a key exists
    if (studentGrades.containsKey("Bob")) {
        System.out.println("Bob's grade: " + studentGrades.get("Bob")); // Output: 92
    }

    // Removing a key-value pair
    studentGrades.remove("Charlie");

    // Iterating over the HashMap
    for (String key : studentGrades.keySet()) {
        System.out.println(key + "'s grade: " + studentGrades.get(key));
    }
}

// Use Cases of HashMaps:
// 1. Database Caching: Frequently accessed data can be stored in a HashMap for quick lookup.
// 2. Counting Frequencies: HashMaps can be used to count the frequency of elements in a collection, such as counting word occurences in a document.
// 3. Dictionary Implementations: HashMaps are often used to implement dictionaries, where words (keys) are mapped to definitions (values).
// 4. Associative Arrays: HashMaps are used in scenarious where you need to quickly map data pairs, like user Ids to user details in a system.

// Advantages of HashMaps:
// - Fast Lookups: Average time complexity for search, insertion, and deletion operations is O(1)
// - Flexible Keys: Can use any object as a key, as long as it provides proper `equals()` and `hashCode()` implementations.
