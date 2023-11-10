// Radix Sort is a non-comparative integer sorting algorithm that sorts data with integer keys by grouping the keys by individual digits that share the same significant position and value.
// It does this for each digit, starting from the least significant digit to the most significant digit.

// Imagine you're organizing a library with thousands of books by their unique 10-digit ISBN numbers.
// Instead of comparing entire numbers, you can sort the books based on each digit, starting from the least significant digit (rightmost) and moving to the most significant digit.
// This way, you're effectively grouping and sorting books at each step based on a part of their ISBN, leading to a fully sorted collection.

fun countingSortForRadix(input: IntArray, placeValue: Int) {
    val n = input.size
    val output = IntArray(n)
    val count = IntArray(10)

    val divisor = Math.pow(10.0, placeValue.toDouble().toInt())

    for (element in input) {
        val digit = (element / divisor) % 10
        count[digit]++
    }

    for (i in 1 until 10) {
        count[i] += count[i - 1]
    }

    for (i in n - 1 downTo 0) {
        val digit = (input[i] / divisor) % 10
        output[count[digit] - 1] = input[i]
        count[digit]--
    }

    for (i in 0 until n) {
        input[i] = output[i]
    }
}
