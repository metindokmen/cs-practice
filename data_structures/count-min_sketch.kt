// The Count-Min Skcetch algorithm is a probabilistic data structure used for approximate counting of events in massive data streams.

// 1. Concept:
// - The Count-Min Sketch is a probabilistic data structure designed to provide approximate frequency counts of items in a stream of data.
// - It uses multiple hash functions and an array of counters to store counts.

// 2. Structure:
// - The CMS consists of a 2-dimensional array of counters, where each row corresponds to a hash function and each column represents a counter.
// - Multiple hash functions are used to hash each item, and the corresponding counters are updated based on the hashed values.
// - The size of the array and the number of hash functions determine the accuracy of the frequency estimates.
