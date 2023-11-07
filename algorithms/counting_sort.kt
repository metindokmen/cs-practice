// Counting Sort is an integer sorting algorithm that operates by counting the number of objects that have each distinct key value.
// It works by calculating the number of elements less than each key to determine the position of each key directly in the output array.
// It's efficient for sorting a small range of integers.

// Imagine you're a teacher with a stack of tests scored from 0 to 100, and you want to sort them by score.
// Instead of comparing tests directly, you can create a tally of each score
// (for instance, a list where the index represents the score and the value at that index is the number of tests with that score).
// Then, you can easily reconstruct a sorted list of tests from this tally.

fun countingSort(arr: IntArray, maxVal: Int): IntArray {
    val n = arr.size
    val count = IntArray(maxVal + 1)
    val output = IntArray(n)

    // Count each element
    for (element in arr) {
        count[element]++
    }

    // Calculate cumulative count
    for (i in 1..maxVal) {
        count[i] += count[i - 1]
    }

    // Place elements in sorted order
    for (element in arr.reversed()) {
        output[count[element] - 1] = element
        count[element]--
    }

    return output
}

fun main() {
    val scores = intArrayOf(50, 99, 98, 85, 50, 70, 65, 85, 100, 65)
    val maxScore = 100 // Assuming scores are from 0 to 100
    val sortedSocres = countingSort(scores, maxScore)
    println("Sorted scores: ${sortedSocres.joinToString(", ")}")
}
