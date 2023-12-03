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

fun binarySearch(arr: IntaArray, left: Int, right: Int, key: Int): Int {
    var l = left
    var r = right
    while (l <= r) {
        val mid = 1 + (r - l) / 2
        when {
            arr[mid] == key -> return mid
            arr[mid] < key -> l = mid + 1
            else -> r = mid - 1
        }
    }
    return -1
}

fun exponentialSearch(arr: IntArray, key: Int): Int {
    if (arr[0] == key) return 0

    var i = 1
    while (i < arr.size && arr[i] <= key) {
        i *= 2
    }

    return binarySearch(arr, i / 2, minOf(i, arr.size - 1), key)
}
