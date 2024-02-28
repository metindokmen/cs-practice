// Binary Indexed Tree, also known as Fenwick Tree, is a data structure that efficiently supports prefix sum queries and updates in a sequence of numbers.

// 1. Structure: A Binary Indexed Tree is represented as an array of size 'n+1', where 'n' is the number of elements in the input sequence.
// Each element of the array stores the cumulative sum of a specific range of elements in the input sequence.

// 2. Operations:
// Construction: The Binary Indexed Tree is built using a bottom-up approach.
// Initially, all elements are set to 0. Then, updates are performed to construct the tree efficiently.
// Update: Updates involve modifying the values in the Binary Indexed Tree array to reflect changes in the input sequence.
// These updates are performed by traversing the tree using bitwise operations.
// Query: Queries for prefix sums are efficiently answered by traversing the tree using bitwise operations to compute cumulative sums.
