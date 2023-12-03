// Exponential Search involves two steps:

// 1. Find the range where the element to be searched could be present.
// 2. Perform a Binary Search in this range.

// First, it checks at indices 1, 2, 4, 8, ... and so on until it find an interval where the element must lie.
// Once the range is found, it performs a binary search between these bounds.
// This algorithm is efficient for unbounded searches where the size of the array is unknown.

// Imagine you're looking for a specific book in a large library with all books sorted by a numbering system.
// If you know the range where the book number might lie, it would be inefficient to start from the beginning.
// Instead, you could use exponential search to quickly narrow down the range, and then use binary search within that range.
// This is particularly efficient when the element to be searched is closer to the beginning of the array.
