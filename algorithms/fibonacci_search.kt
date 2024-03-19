// Fibonacci Search is an algorithm which efficiently finds the position of a target value in a sorted array.

// 1. Concept:
// - Fibonacci Search is an efficient search algorithm similar to binary search, but it divides the array into Fibonacci sequence-sized subarrays instead of halves.
// - It works best for uniformly distributed arrays.

// 2. Algorithm:
// - Find the smallest Fibonacci number greater than or equal to the size of the array. Let this number be `fibM`.
// - Initialize two Fibonacci numbers `fibM2` and `fibM1` such that `fibM2 = fibM - fibM1`
// - Compare the target value with the element at index `fibM2` in the array.
// - If the target value is less than the element at index `fibM2`, search in the subarray to the left of `fibM2` using recursive Fibonacci search with `fibM1` and `fibM2 - fibM1`
// - If the target value is greater than the element at index `fibM2`, search in the subarray to the right of `fibM2` using recursive Fibonacci search with `fibM1` and `fibM2`.

// Imagine you have a library of books sorted alphabetically by title.
// You want to find a particular book but don't know its exact location.
// Using Fibonacci Search, you can quickly narrow down the section of the library where the book might be located, making the search process more efficient.
