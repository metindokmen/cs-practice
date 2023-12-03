// Exponential Search involves two steps:

// 1. Find the range where the element to be searched could be present.
// 2. Perform a Binary Search in this range.

// First, it checks at indices 1, 2, 4, 8, ... and so on until it find an interval where the element must lie.
// Once the range is found, it performs a binary search between these bounds.
// This algorithm is efficient for unbounded searches where the size of the array is unknown.
