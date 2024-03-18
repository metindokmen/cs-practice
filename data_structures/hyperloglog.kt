// HyperLogLog is a probabilistic data structure used for approximating the number of distinct elements in a multiset.

// 1. Concept:
// - HyperLogLog (HLL) is a probabilistic algorithm designed to estimate the cardinality (number of distinct elements) of a multiset with a high accuracy rate using minimal memory space.
// - It works by hashing elements of the multiset and maintaining a set of registers to estimate the number of leading zeros in the binary representation of hash values.
