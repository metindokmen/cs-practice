// The Count-Min Skcetch algorithm is a probabilistic data structure used for approximate counting of events in massive data streams.

// 1. Concept:
// - The Count-Min Sketch is a probabilistic data structure designed to provide approximate frequency counts of items in a stream of data.
// - It uses multiple hash functions and an array of counters to store counts.

// 2. Structure:
// - The CMS consists of a 2-dimensional array of counters, where each row corresponds to a hash function and each column represents a counter.
// - Multiple hash functions are used to hash each item, and the corresponding counters are updated based on the hashed values.
// - The size of the array and the number of hash functions determine the accuracy of the frequency estimates.

// 3. Operations:
// - Increment: When an item is encountered in the stream, its frequency count is incremented in each counter location determined by the hash functions.
// - Estimate: To estimate the frequency of an item, its hashed values are used to retrieve the counts from the corresponding counter locations, and the minimum count among all locations is considered as the estimated frequency.
