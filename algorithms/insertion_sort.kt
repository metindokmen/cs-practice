// Insertion Sort is a simple sorting algorithm that build the final sorted array (or list) one item at a time.
// It is much less efficient on lage lists than more advanced algorithms like quicksort, heapsort, or merge sort.
// However, it has several advantages, such as simple implementation, efficient for small data sets, and more efficent in practice than most other simple quadratic algorithms (like selection sort or bubble sort)

// Imagine you're palying a card game where you need to keep your hand of cards sorted at all times.
// As you draw each new card, you insert it into its proper place within your already sorted hand, shifting the other cards as neccessary.
// This process is similar to how the Insertion Sort algorithm works.

fun insertionSort(arr: IntArray) {
    for (i in 1 until arr.size) {
        val key = arr[i]
        var j = i - 1

        // Move elements of arr[0..i-1], that are greater than key,
        // to one position ahead of their current position
        while (j >= 0 && arr[j] > key) {
            arr[j + 1] = arr[j]
            j--
        }
        arr[j + 1] = key
    }
}

fun main() {
    val numbers = intArrayOf(12, 11, 13, 5, 6)
    insertionSort(numbers)
    println("Sorted array: ${numbers.joinToString(", ")}")
}
