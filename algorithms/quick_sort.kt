// QuickSort is an efficient, in-place, comparison-based sorting algorithm.
// It works on the divide-and-conquer principle, where the main idea is to select a 'pivot' element,
// and partition the array such that all elements smaller than the pivot are to its left,
// and all elements greater than the pivot are to its right.
// This process is recursively applied to the two sub-arrays, leading to a sorted list.

// Imagine you have a stack of books, and you want to arrange them in increasing order of their thickness.
// You randomly pick a book (the 'pivot') and then place all thinner books to its left and all thicker books to its right.
// You then repeat this process for the two stacks on either side of the pivot.
// Eventually, all the books are sorted by thickness.

fun quickSort(arr: IntArray, low: Int, high: Int) {
    if (low < high) {
        // pi is the partitioning index - arr[pi] is in its correct position
        val pi = partition(arr, low, high)

        // Recursively sort elements before and after partition
        qucikSort(arr, low, pi - 1)
        quickSort(arr, pi + 1, high)
    }
}

fun partition(arr: IntArray, low: Int, high: Int): Int {
    val pivot = arr[high]
    var i = low - 1 // Index of smaller element

    for (j in low until high) {
        // If the current element in smaller than or equal to the pivot
        if (arr[j] <= pivot) {
            i++

            // Swap arr[i] and arr[j]
            val temp = arr[i]
            arr[i] = arr[j]
            arr[j] = temp
        }
    }

    // Swap arr[i + 1] and arr[high] (the pivot)
    val temp = arr[i + 1]
    arr[i + 1] = arr[high]
    arr[high] = temp

    return i + 1
}

fun main() {
    val booksByThickness = intArrayOf(5, 1, 9, 3, 7, 6, 8, 2, 4)
    quickSort(booksByThickness, 0, booksByThickness.size - 1)
    println(booksByThickness.joinToString(", ")) // Output: 1, 2, 3, 4, 5, 6, 7, 8. 9
}