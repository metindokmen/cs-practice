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

fun fibonacciSearch(arr: IntArray, x: Int): Int {
    val n = arr.size
    var fibM2 = 0 // (m-2)'th Fibonacci Number
    var fibM1 = 1 // (m-1)'th Fibonacci Number
    var fibM = fibM1 - fibM2 // m'th Fibonacci Number
    while (fibM < n) {
        fibM2 = fibM1
        fibM1 = fibM
        fibM = fibM1 + fibM2
    }
    var offset = -1
    while (fibM > 1) {
        val i = minOf(offset + fibM2, n - 1)
        if (arr[i] < x) {
            fibM = fibM1
            fibM1 = fibM2
            fibM2 = fibM - fibM1
            offset = i
        } else if (arr[i] > x) {
            fibM = fibM2
            fibM1 -= fibM2
            fibM2 = fibM - fibM1
        } else return i
    }
    return if (fibM1 == 1 && arr[offset + 1] == x) offset + 1 else - 1
}

fun main() {
    val arr = intArrayOf(10, 22, 35, 40, 45, 50, 80, 82, 85, 90, 100)
    val x = 85
    val index = fibonacciSearch(arr, x)
    if (index != -1) {
        println("Element $x found at index $index")
    } else {
        println("Element $x not found in the array")
    }
}
