// Interpolation Search is an algorithm for searching for a key in an array that has been ordered numerical values assigned to the keys (key values).
// It works on the principle of estimating the position of the key based on the lowest and highest elements in the array and the value of the key.
// It's particularly efficient for uniformly distributed data, where it can achieve O(log log n) complexity, as opposed to Binary Search's O(log n).

// Imagine you're looking for a specific page in a thick, well-indexed book.
// Instead of flipping through each page (like in linear search) or dividing the book into halves repeatedly (as in binary search),
// you estimate where in the book the page might be based on the page numbers.
// For example, if you're looking for page 750 in a 1000-page book, you'd start around three-quarters of the way through.
// This is similar to how Interpolation Search works, as it estimates where in the sorted list the searched value might be for faster results.

fun interpolationSearch(arr: Array<Int>, key: Int): Int {
    var low = 0
    var high = arr.size - 1

    while (arr[high] != arr[low] && key >= arr[low] && key <= arr[high]) {
        val mid = low + ((key - arr[low]) * (high - low) / (arr[high] - arr[low]))

        when {
            arr[mid] < key -> low = mid + 1
            arr[mid] > key -> high - mid - 1
            else -> return mid
        }
    }

    return if (arr[low] == key) low else - 1
}
