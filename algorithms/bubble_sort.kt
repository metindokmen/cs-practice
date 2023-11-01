// Bubble Sort is a simple sorting algorithm that repeatedly steps through the list, compares adjacent elements,
// and swaps them if they are in the wrong order. The pass through the list is repeated until the list is sorted.

// Imagine you have a deck of cards, and you want to arrange them in ascending order based on their values.
// You can use the Bubble Sort technique: repeatedly step through the deck, compare each pair of adjacent cards, and swap them if they are in the wrong order.
// This process is repeated until no swaps are needed, indicating that the deck is sorted.

fun bubbleSort(arr: IntArray): IntArray {
    var n = arr.size
    var swapped: Boolean

    do {
        swapped = false
        for (i in 1 until n) {
            if (arr[i - 1] > arr[i]) {
                // Swap arr[i-1] and arr[i]
                val temp = arr[i - 1]
                arr[i - 1] = arr[i]
                arr[i] = temp

                // Mark that a swap occurred
                swapped = true
            }
        }
        n--
    } while (swapped)

    return arr
}

fun main() {
    val numbers = intArrayOf(64, 34, 25, 12, 22, 11, 90)
    val sortedNumbers = bubbleSort(numbers)
    println("Sorted Array: ${sortedNumbers.joinToString(", ")}")
}
