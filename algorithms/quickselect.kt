// Quickselect is a selection algorithm to find the k'th smallest element in an unordered list.
// It is related to the Quicksort sorting algorithm and is typically efficient for this task because it works in expected O(n) time complexity.
// It uses a partioning method similar to Quicksort to recursively divide the list.

// Suppose you're participating in a race, and after the race, you want to quickly find the runner who finished in the 5th place.
// Going through the entire list of participants and ordering them from fastest to slowest would be inefficient.
// Quickselect is an algorithm that can find the k'th smallest (or largest) element in an unordered list without sorting the entire list.

fun quickSelect(arr: IntArray, k: Int): Int {
    return quickSelect(arr, 0, arr.size - 1, k - 1)
}

fun quickSelect(arr: IntArray, low: Int, high: Int, k: Int): Int {
    val pivotIndex = partition(arr, low, high)
    when {
        pivotIndex == k -> return arr[pivotIndex]
        pivotIndex > k -> return quickSelect(arr, low, pivotIndex - 1, k)
        else -> return quickSelect(arr, pivotIndex + 1, high, k)
    }
}

fun partition(arr: IntArray, low: Int, high: Int): Int {
    val pivot = arr[high]
    var i = low
    for (j in low until high) {
        if (arr[j] <= pivot) {
            arr[i] = arr[j].also { arr[j] = arr[i] }
            i++
        }
    }
    arr[i] = arr[high].also { arr[high] = arr[i] }
    return i
}

fun main() {
    val times = intArrayOf(24, 52, 17, 30, 44, 27, 42, 13, 36, 29)
    val k = 5
    println("The ${k}th fastest runner finished in ${quickSelect(times, k)} minutes.")
}
