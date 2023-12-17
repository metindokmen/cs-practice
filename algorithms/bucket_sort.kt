// Bucket Sort is an efficient sorting algorithm for sorting elements that are uniformly distributed across a range.
// It works by distributing elements into several "buckets" and then sorting these buckets individually.
// Each bucket is sorted individually using a different sorting algorithm, typically insertion sort, due to its efficiency with small data sets.

// Imagine you're a teacher with a large stack of exams scored between 0 and 100, and you need to sort them.
// Instead of comparing each exam with others (like in bubble sort or quicksort), you can create 10 buckets, each representing a range of 10 scores.
// You then distribute the exams into these buckets based on their scores.
// Finally, you sort the exams within each bucket and then combine them back.
// This method can be much faster for such a specific case, especially with a large number of exams.
// This is essentially what Bucket Sort does.

fun insertionSort(arr: MutableList<Int>) {
    for (i in 1 until arr.size) {
        val key = arr[i]
        var j = i - 1

        while (j >= 0 && arr[j] > key) {
            arr[j + 1] = arr[j]
            j--
        }
        arr[j + 1] = key
    }
}

fun bucketSort(arr: IntArray): List<Int> {
    val maxVal = arr.maxOrNull() ?: 0
    val bucketCount = maxVal / 10 + 1
    val buckets: Array<MutableList<Int>> = Array(bucketCount) { mutableListOf() }

    // Distribute the elements into buckets
    for (i in arr.indices) {
        val index = arr[i] / 10
        buckets[index].add(arr[i])
    }

    // Sort each bucket and merge them
    val sortedArray = mutableListOf<Int>()
    for (bucket in buckets) {
        insertionSort(bucket)
        sortedArray.addAll(bucket)
    }
    return sortedArray
}

fun main() {
    val scores = intArrayOf(47, 75, 85, 50, 90, 92, 88, 66)
    val sortedScores = bucketSort(scores)
    println("Sorted Scores: $sortedScores")
}
